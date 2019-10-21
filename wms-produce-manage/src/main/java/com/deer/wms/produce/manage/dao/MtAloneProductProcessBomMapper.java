package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtAloneProductProcessBom;
import com.deer.wms.produce.manage.model.MtAloneProductProcessBomParams;
import com.deer.wms.produce.manage.model.MtAloneProductProcessBomVO;
import com.deer.wms.project.seed.core.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MtAloneProductProcessBomMapper extends Mapper<MtAloneProductProcessBom> {
    List<MtAloneProductProcessBom> findByProductId(@Param("productId") Integer productId);

    List<MtAloneProductProcessBomVO> findByProductNameAndProductNum(MtAloneProductProcessBomParams mtAloneProductProcessBomParams);

}