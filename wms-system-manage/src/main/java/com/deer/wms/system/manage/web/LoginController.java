package com.deer.wms.system.manage.web;

import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.util.NetworkUtil;
import com.deer.wms.system.manage.model.permission.Menu;
import com.deer.wms.system.manage.model.user.UserDetail;
import com.deer.wms.system.manage.model.user.UserLogin;
import com.deer.wms.system.manage.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Floki on 2017/9/16.
 */
@Api(description = "用户登录api接口")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     *
     * @param login
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping
    @OperateLog(description = "用户登录", type = "登录")  
    public Result userLogin(@RequestBody UserLogin login, HttpServletRequest request) {
        String ip = NetworkUtil.getIpAddress(request);
        login.setIp(ip);
        System.out.println(login.getPassword());
        UserDetail detail = loginService.login(login);
        List<Menu> menus = detail.getMenus();
        List<Menu> menus1 =  new ArrayList<Menu>();
        List<Menu> menus2 = new ArrayList<Menu>();
        List<Menu> menus3 = new ArrayList<Menu>();
        for(Menu menu :menus){
            if(menu.getGroup() !=null){
                if(menu.getGroup() ==1){
                    menus1.add(menu);
                }
                if(menu.getGroup() ==2){
                    menus2.add(menu);
                }
                if(menu.getGroup() ==3){
                    menus3.add(menu);
                }
            }
        }
        detail.setMenus1(menus1);
        detail.setMenus2(menus2);
        detail.setMenus3(menus3);
        return ResultGenerator.genSuccessResult(detail);
    }
    
    /**
     * 用户登录2
     *
     * @param login
     * @return
     */
    @ApiOperation(value = "用户登录2", notes = "用户登录2")
    @PostMapping("/temp")
    @OperateLog(description = "用户登录2", type = "登录2")  
    public Result userLoginTemp(@RequestBody UserLogin login, HttpServletRequest request) {
        UserDetail detail = loginService.login(login);
        detail.setMenus(null);
        detail.setUrls(null);
        detail.setPermission(null);
        return ResultGenerator.genSuccessResult(detail); 
    }
    
    /**
     * 用户登录3
     *
     * @param login
     * @return
     */
    @ApiOperation(value = "用户权限控制登录", notes = "用户权限控制登录")
    @PostMapping("/verify")
    @OperateLog(description = "用户权限控制登录", type = "用户权限控制登录")  
    public Result userLoginVerify(@RequestBody UserLogin login, HttpServletRequest request) {
        UserDetail detail = loginService.loginVerify(login);
        return ResultGenerator.genSuccessResult(detail); 
    }
}