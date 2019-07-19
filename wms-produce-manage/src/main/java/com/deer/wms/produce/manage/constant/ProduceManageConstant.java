package com.deer.wms.produce.manage.constant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.deer.wms.project.seed.util.RandomUtil;

/**
 * Created by Floki on 2017/9/30.
 */
public class ProduceManageConstant {
    /**
     * 项目基础包名称，根据公司实际项目修改
     */
    public static final String BASE_PACKAGE = "com.deer.wms.produce.manage";

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
     * CK=出库类型单号；
     */
    public static final String DELIVERY_ORDER_TYPE = "CK";
    /**
     * PD=盘点类型单号；
     */
    public static final String STOCKTAKING_ORDER_TYPE = "PD";
    /**
     * DJJ=打卷机编号
     */
    public static final String WINDING_MACHINE_TYPE = "DJJ";

}
