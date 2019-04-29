package com.deer.wms.system.manage.interceptor;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.deer.wms.intercept.common.data.CommonDataServiceManager;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.util.IPUtil;
import com.deer.wms.project.seed.util.NetworkUtil;
import com.deer.wms.system.manage.constant.SystemManageConstant;
import com.deer.wms.system.manage.model.MtAloneLog;
import com.deer.wms.system.manage.service.MtAloneLogService;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

/**
 * Description: String methodName = (pjd.getTarget().getClass().getName() + "."
 * + pjd.getSignature().getName() + "()");
 * 
 * @author gtt
 * @date 2019年1月17日
 * @version 1.0
 */

@Aspect
@Component
public class OperLogInterceptor {

	@Autowired
	private MtAloneLogService logService;
	@Autowired()
	private CommonDataServiceManager commonDataService;

	// 这里写的为环绕触发 ，可自行根据业务场景选择@Before @After
	// 触发条件为：com.deer.wms包下面所有类且注解为OperLog的
	@Around("within(com.deer.wms..*) && @annotation(com.deer.wms.project.seed.annotation.OperateLog)")
	public Object doAroundMethod(ProceedingJoinPoint pjd) throws Throwable {

		long startTime = System.currentTimeMillis();// 开始时间

//		Object[] params = pjd.getArgs();// 获取请求参数
//		System.out.println("监听到传入参数为:");
//		for (Object param : params) {
//			System.out.println(param);
//		}
		System.out.println("=====Service前置通知结束=====");
		// ###################上面代码为方法执行前#####################
		Object result = pjd.proceed();// 执行方法，获取返回参数
		// ###################下面代码为方法执行后#####################
		System.out.println("返回参数为:" + result);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
		Browser browser = userAgent.getBrowser();  
		System.out.println("User-Agent为:" + request.getHeader("User-Agent"));
		OperatingSystem os = userAgent.getOperatingSystem();
		System.out.println("请求browser:" + browser.getName());
		System.out.println("请求os:" + os.getName());
		// 请求的IP
		String ip = NetworkUtil.getIpAddress(request);
		String token = request.getHeader("access-token");
		if(token == null || "null".equals(token)) {
			token = request.getHeader("token");
		}
		System.out.println("请求token:" + token);
		Map<String, String> logMap = getAnnotationInfo(pjd);
		System.out.println("方法类型:" + logMap.get("type"));
		System.out.println("日志信息:" + logMap.get("description"));
		System.out.println("请求IP:" + ip);
		System.out.println("url =" + request.getRequestURI());

		long endTime = System.currentTimeMillis();// 结束时间
		float excTime = (float) (endTime - startTime) / 1000;
		System.out.println("执行时间:" + excTime + "s");
		// 获取登录用户名字
		MtAloneLog log = new MtAloneLog();
		if(!StringUtils.isEmpty(ip)) {
			log.setLocation(IPUtil.getCityInfo(ip));
		}
		if (token != null && !"null".equals(token)) {
			CurrentUser user = commonDataService.getCurrentUserDataFromRedis(token);
			System.out.println("用户:");
			System.out.println(user);
//			System.out.println("用户名字:" + user == null ? "" : user.getUserName());
			log.setOperateUserName(user == null ? SystemManageConstant.LOG_USER_NAME_NO_TOKEN  : user.getUserName());
			log.setOperateUserId(user == null ? SystemManageConstant.LOG_USER_ID_NO_TOKEN : user.getUserId());
		} else {
			//如果是没有token，登录操作
			Object res = getFieldValueByName("data", result);
			System.out.println(res);
			Object userName = getFieldValueByName("userName", res);
			System.out.println(userName);
			Object userId = getFieldValueByName("userId", res);
			System.out.println(userId);
			log.setOperateUserName(userName == null ? SystemManageConstant.LOG_USER_NAME_NO_TOKEN : (String)userName);
			log.setOperateUserId(userId == null ? SystemManageConstant.LOG_USER_ID_NO_TOKEN : (Integer)userId);
		}
		// 存储到数据库
		log.setLogDescription(logMap.get("description"));
		log.setResult(""+getFieldValueByName("message", result));
		log.setLogType(logMap.get("type"));
		log.setNotes(logMap.get("notes"));
		log.setOperateIp(ip);
		log.setOperateTime(new Date());
		log.setDuration(excTime);
		log.setActionUrl(request.getRequestURI());
		log.setBrowser(browser.getName());
		log.setOs(os.getName());
		logService.save(log);
		return result;

	}

	/**
	 * 获取注解的信息
	 * 
	 * @param joinPoint
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static Map<String, String> getAnnotationInfo(JoinPoint joinPoint) {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = null;
		Map<String, String> logMap = new HashMap<>();
		try {
			targetClass = Class.forName(targetName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		assert targetClass != null;
		Method[] methods = targetClass.getMethods();
		String type = "type";
		String description = "description";
		String notes = "notes";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					type = method.getAnnotation(OperateLog.class).type();
					description = method.getAnnotation(OperateLog.class).description();
					notes = method.getAnnotation(OperateLog.class).notes();
					break;
				}
			}
		}
		logMap.put("type", type);
		logMap.put("description", description);
		logMap.put("notes", notes);
		return logMap;
	}

	/**
	 * 根据属性名获取属性值
	 */
	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
