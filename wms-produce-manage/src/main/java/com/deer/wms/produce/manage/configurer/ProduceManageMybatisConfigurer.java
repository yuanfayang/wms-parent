package com.deer.wms.produce.manage.configurer;


import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.project.seed.configurer.AbstractMybatisConfigurer;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
//@Configuration
public class ProduceManageMybatisConfigurer extends AbstractMybatisConfigurer {

    @Override
    public  String getTypeAliasesPackage() {
        return    ProduceManageConstant.MODEL_PACKAGE; }

    @Override
    public String getMapperLocations() {
        return   ProduceManageConstant.MAPPER_LOCATIONS;
    }

    @Override
    public String getBasePackage() {
        return   ProduceManageConstant.DAO_PACKAGE;
    }

}

