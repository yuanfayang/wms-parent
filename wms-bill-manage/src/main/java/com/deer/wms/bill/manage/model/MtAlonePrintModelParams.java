package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by  on 2019/02/21.
*/
public class MtAlonePrintModelParams extends QueryParams {
	
	/**
	 * 模版类型
	 */
	private Integer printModelType;

	public Integer getPrintModelType() {
		return printModelType;
	}

	public void setPrintModelType(Integer printModelType) {
		this.printModelType = printModelType;
	}
}
