package com.deer.wms.detect.configurer;


import com.deer.wms.detect.constant.DetectConstant;
import com.deer.wms.project.seed.configurer.AbstractMybatisConfigurer;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
//@Configuration
public class DetectMybatisConfigurer extends AbstractMybatisConfigurer {

    @Override
    public  String getTypeAliasesPackage() { return DetectConstant.MODEL_PACKAGE; }

    @Override
    public String getMapperLocations() {
        return DetectConstant.MAPPER_LOCATIONS;
    }

    @Override
    public String getBasePackage() {
        return DetectConstant.DAO_PACKAGE;
    }

}

