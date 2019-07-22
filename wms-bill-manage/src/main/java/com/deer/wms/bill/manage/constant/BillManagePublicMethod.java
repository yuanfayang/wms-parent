package com.deer.wms.bill.manage.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.deer.wms.project.seed.util.RandomUtil;


public class BillManagePublicMethod {
	
	public static  String creatBarCode(String maxBarcode) {
    	Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    	String timePartStr = sdf1.format(date);
    	String newBarcode;
    	if(maxBarcode!=null) {
        	Integer randomPart=Integer.valueOf(maxBarcode.substring(8));
        	Integer randomPartRemainder=randomPart%100000+1;
            String numberStr = String.format("%06d", randomPartRemainder);   
            newBarcode=timePartStr+numberStr;
    	}else {
    		String numberStr = "000001";
            newBarcode=timePartStr+numberStr;
    	}
    	return newBarcode;
    }
	
	public static String creatOrderCode(String orderType) {
		String orderCode=null;
    	Date date = new Date();
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
    	String bach= sdf.format(date);
    	String rondomStr=RandomUtil.generateString(4);
		if(orderType.equals(BillManageConstant.DELIVERY_ORDER_TYPE)) {
			orderCode=orderType+bach+rondomStr;
		}
		if(orderType.equals(BillManageConstant.STOCKTAKING_ORDER_TYPE)){
			orderCode=orderType+bach+rondomStr;
		}
		if(orderType.equals(BillManageConstant.WINDING_MACHINE_TYPE)){
			orderCode=orderType+bach+rondomStr;
		}
		return orderCode;
	}

	public static String creatInBoundOrderCode(){
		String orderCode=null;
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
		String bach= sdf.format(date);
		String rondomStr=RandomUtil.generateString(4);
		orderCode="RK"+bach+rondomStr;
		return orderCode;
	}
}
