package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;
import lombok.Data;

import java.util.List;

/**
* Created by  on 2019/09/06.
*/
@Data
public class MtAloneStockProductParams extends QueryParams {

    private Integer productTypeId;

    private String productTypeCode;

    private Integer productVarietyId;

    private String begDate;

    private String endDate;

    private List<String> headersName;
}
