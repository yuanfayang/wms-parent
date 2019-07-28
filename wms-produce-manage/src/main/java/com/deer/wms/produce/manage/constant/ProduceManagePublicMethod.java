package com.deer.wms.produce.manage.constant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.deer.wms.project.seed.util.RandomUtil;


public class ProduceManagePublicMethod {

    /**
     * 自动生成唯一的物料编码，规则：类型简称（type）+20190728+UUID后十位
     * type:WL,物料编码；SCJH，生产计划编码
     * @return
     */
    public static String creatUniqueCode(String type) {
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddhh");
        String timePartStr = sdf1.format(date);
        String uuidStr = UUID.randomUUID().toString().substring(24);
        String newCode = type+timePartStr+uuidStr;

        return newCode;
    }



    //public static String creatOrderCode(String orderType) {
	//	String orderCode=null;
    	//Date date = new Date();
    	//SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
    	//String bach= sdf.format(date);
    	//String rondomStr=RandomUtil.generateString(4);
	//	if(orderType.equals(ProduceManageConstant.DELIVERY_ORDER_TYPE)) {
	//		orderCode=orderType+bach+rondomStr;
	//	}
	//	if(orderType.equals(ProduceManageConstant.STOCKTAKING_ORDER_TYPE)){
	//		orderCode=orderType+bach+rondomStr;
	//	}
	//	if(orderType.equals(ProduceManageConstant.WINDING_MACHINE_TYPE)){
	//		orderCode=orderType+bach+rondomStr;
	//	}
	//	return orderCode;
	//}
}
