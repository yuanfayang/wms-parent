package ${basePackage}.service;

import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.model.${modelNameUpperCamel}Params;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service extends Service<${modelNameUpperCamel}, ${type}> {


    List<${modelNameUpperCamel}> findList(${modelNameUpperCamel}Params  params) ;

}
