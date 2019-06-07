package com.deer.wms.workflow.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * SpringContextUtil
 *
 * @author luxin.yan
 * @date 2019/1/24
 **/
@Configuration
public class SpringContextUtil implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if (SpringContextUtil.applicationContext == null) {

            SpringContextUtil.applicationContext = applicationContext;

        }
        logger.info("ApplicationContext配置成功,applicationContext对象：" + SpringContextUtil.applicationContext);

    }

    public static ApplicationContext getApplicationContext() {

        return applicationContext;

    }

    public static Object getBean(String name) {

        return getApplicationContext().getBean(name);

    }
    public static Object getBeanByClazz(String clazz) throws ClassNotFoundException{

        return getApplicationContext().getBean(Class.forName(clazz));

    }
    public static <T> T getBean(Class<T> clazz) {

        return getApplicationContext().getBean(clazz);

    }

    public static <T> T getBean(String name, Class<T> clazz) {

        return getApplicationContext().getBean(name, clazz);

    }

}