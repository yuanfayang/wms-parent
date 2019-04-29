package com.deer.wms.detect.model;

import java.util.List;

public class SampleClothDTO extends SampleCloth {
	
    private List<MtAloneAccessory> accessorys;

	public List<MtAloneAccessory> getAccessorys() {
		return accessorys;
	}

	public void setAccessorys(List<MtAloneAccessory> accessorys) {
		this.accessorys = accessorys;
	}
}
