package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneBarcode;
import com.deer.wms.bill.manage.model.MtAloneBarcodeParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneBarcode;

/**
 * Created by  on 2019/03/13.
 */
public interface MtAloneBarcodeService extends Service<MtAloneBarcode, Integer> {

	String getMaxBarcode();


}
