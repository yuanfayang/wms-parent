package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by  on 2018/12/08.
*/
public class MtAloneDeliveryOrderCriteria extends QueryCriteria {
	    private String keyWord;
	    private String begDate;
	    private String endDate;
	    private String deliveryOrderCode;

		public String getDeliveryOrderCode() {
			return deliveryOrderCode;
		}
		public void setDeliveryOrderCode(String deliveryOrderCode) {
			this.deliveryOrderCode = deliveryOrderCode;
		}
		public String getKeyWord() {
			return keyWord;
		}
		public void setKeyWord(String keyWord) {
			this.keyWord = keyWord;
		}
		public String getBegDate() {
			return begDate;
		}
		public void setBegDate(String begDate) {
			this.begDate = begDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
	    
}
