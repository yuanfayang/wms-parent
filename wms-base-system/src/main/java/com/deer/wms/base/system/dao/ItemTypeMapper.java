package com.deer.wms.base.system.dao;
import com.deer.wms.base.system.model.ItemType;
import com.deer.wms.base.system.model.ItemTypeCriteria;
import com.deer.wms.base.system.model.ItemTypeParams;
import com.deer.wms.project.seed.core.mapper.Mapper;
import java.util.List;

public interface ItemTypeMapper extends Mapper<ItemType> {

    void deleteByCodeAndCom(ItemTypeCriteria criteria);
    List<ItemType> findList(ItemTypeCriteria criteria);

    List<ItemType> findListNew(ItemTypeParams params);

    void deleteByIdAndCom(ItemTypeParams params);

    Integer countRelProducts(ItemTypeParams params);

    Integer countChildren(ItemTypeParams params);

    List<ItemType> findChildrenList(ItemTypeParams params);

    ItemType findParent(ItemTypeParams params);

    List<ItemType> getVarietyTypeList(ItemTypeParams params);
}