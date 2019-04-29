package com.deer.wms.workflow.flowable.jsonConverter;

import org.flowable.editor.language.json.converter.BpmnJsonConverter;

/**
 * MyBpmnJsonConverter
 *  解析自定义扩展属性
 * @author luxin.yan
 * @date 2019/2/28
 **/
public class MyBpmnJsonConverter extends BpmnJsonConverter {

    public MyBpmnJsonConverter() {
        MyUserTaskJsonConverter.fillTypes(convertersToBpmnMap, convertersToJsonMap);
    }
}
