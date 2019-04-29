package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneBarcode;
import com.deer.wms.bill.manage.model.MtAloneBarcodeParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneBarcodeMapper extends Mapper<MtAloneBarcode> {

	String getMaxBarcode();
}