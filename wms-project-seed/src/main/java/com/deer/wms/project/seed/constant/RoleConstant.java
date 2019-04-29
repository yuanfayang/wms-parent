package com.deer.wms.project.seed.constant;

/**
 * 
 * @author guotuanting
 * @date 2019-03-08
 */
public class RoleConstant {
    /**
     * 角色的级别  0-盟通超级管理员  1-盟通管理员     2-其他公司管理员  3-其他公司业务员
     */
    public static final int MT_SUPER_ADMIN = 0;
    public static final int MT_ADMIN = 1;
    public static final int OTHER_ADMIN = 2;
    public static final int OTHER_USER = 3;  
    
    //预留一个开发的超级管理员角色无法删除
    public static final String SUPER_ADMIN_ROLE_NAME  = "role@18968192520";   

}
