package com.deer.wms.bill.manage.model;

import java.util.ArrayList;
import java.util.List;

public class MtAloneProductDetNewCell{
      String newCellCode;
      List<MtAloneProductDet> mtAloneProductDetList;
      
      

	public List<MtAloneProductDet> getMtAloneProductDetList() {
		return mtAloneProductDetList;
	}

	public void setMtAloneProductDetList(List<MtAloneProductDet> mtAloneProductDetList) {
		this.mtAloneProductDetList = mtAloneProductDetList;
	}

	public String getNewCellCode() {
		return newCellCode;
	}

	public void setNewCellCode(String newCellCode) {
		this.newCellCode = newCellCode;
	}

}
