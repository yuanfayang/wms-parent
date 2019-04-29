package com.deer.wms.bill.manage.model;

import java.util.List;

public class MtAloneTagAndField{
	 MtAloneTag mtAloneTag;
     private List<MtAloneTagField> tagFieldList;

	public List<MtAloneTagField> getTagFieldList() {
		return tagFieldList;
	}

	public void setTagFieldList(List<MtAloneTagField> tagFieldList) {
		this.tagFieldList = tagFieldList;
	}

	public MtAloneTag getMtAloneTag() {
		return mtAloneTag;
	}

	public void setMtAloneTag(MtAloneTag mtAloneTag) {
		this.mtAloneTag = mtAloneTag;
	}
     
}
