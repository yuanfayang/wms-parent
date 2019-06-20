package com.deer.wms.base.system.service;
import com.deer.wms.base.system.model.ItemType;
import com.deer.wms.base.system.model.ItemTypeCriteria;
import com.deer.wms.base.system.model.ItemTypeParams;
import com.deer.wms.project.seed.core.service.Service;

import java.util.List;


/**
 * Created by  on 2018/06/28.
 */
public interface ItemTypeService extends Service<ItemType, Integer> {

    void  deleteByCodeAndCom(ItemTypeCriteria criteria);
    List<ItemType> findList(ItemTypeCriteria  criteria);

    List<ItemType> findListNew(ItemTypeParams params);

    void deleteByIdAndCom(ItemTypeParams params);

    Integer countRelProducts(ItemTypeParams params);

    Integer countChildren(ItemTypeParams params);

    List<ItemType> findChildrenList(ItemTypeParams params);

    ItemType findParent(ItemTypeParams params);

    List<ItemType> getVarietyTypeList(ItemTypeParams params);
}
