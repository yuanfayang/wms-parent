package com.deer.wms.project.seed.constant;

/**
 * Created by Floki on 2017/9/30.
 */
public class SystemManageConstant {
    /**
     * 项目基础包名称，根据公司实际项目修改
     */
    public static final String BASE_PACKAGE = "com.deer.wms.system.manage";

    /**
     * Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";

    /**
     * Dao所在包
     */
    public static final String DAO_PACKAGE = BASE_PACKAGE + ".dao";

    /**
     * MapperLocations
     */
    public static final String MAPPER_LOCATIONS = "classpath*:com/deer/wms/**/mapper/*.xml";

    /**
     * -1=托盘运营商；0:MT(超级管理员)；1=托盘生产商；2=投资商；3=运营代理商；4=托盘承租方；5=POI；
     * 公司类型：托盘运营商
     */
    public static final int COMPANY_TYPE_OPERATE = -1;

    public static final int COMPANY_TYPE_MT = 0;
    /**
     * 没有token验证，不知道用户id。默认为-999，用户名为未验证
     * 
     */
    public static final int LOG_USER_ID_NO_TOKEN = -999;
    public static final String LOG_USER_NAME_NO_TOKEN = "未验证";
    
}
