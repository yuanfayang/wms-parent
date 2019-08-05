package com.deer.wms.bill.manage.constant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.deer.wms.project.seed.util.RandomUtil;

/**
 * Created by Floki on 2017/9/30.
 */
public class BillManageConstant {
    /**
     * 项目基础包名称，根据公司实际项目修改
     */
    public static final String BASE_PACKAGE = "com.deer.wms.bill.manage";

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
    /**
     * 入库单审核业务模板ID
     */
    public static final Integer INBOUND_TASK_MB_ID = 1;

    /**
     * 出库单审核业务模板ID
     */
    public static final Integer OUTBOUND_TASK_MB_ID = 2;

}
