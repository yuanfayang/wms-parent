package com.deer.wms.base.system.constant;

/**
 * Created by Floki on 2017/9/30.
 */
public class BaseSystemConstant {
    /**
     * 项目基础包名称，根据公司实际项目修改
     */
    public static final String BASE_PACKAGE = "com.deer.wms.base.system";

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

    public static final int ITEM_TYPE = 0;//item_type表中item_type_state字段为0，即产品分类标识

    public static final int ITEM_VARIETY = 1;//item_type表中item_type_state字段为1，即产品品种标识
}
