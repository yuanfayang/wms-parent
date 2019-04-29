package com.deer.wms.workflow.constant;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * FormConstant
 * 表单中一些固定意义的参数
 *
 * @author luxin.yan
 * @date 2019/2/11
 **/
public class FormConstant {
    /**
     * 下一节点审批人
     */
    public static final String YUNLI_DOCUMENT_APPROVER = "yunli_document_approver";
    /**
     * 下下级节点接收人
     */
    public static final String YUNLI_DOCUMENT_RECIPIENT = "yunli_document_recipient";
    /**
     * 加签任务节点
     */
    public static final String YUNLI_DOCUMENT_ADDTASK = "yunli_document_addtask";

    /**
     * 解析出人员ID集合
     */
    public static Set<String> parseJsonToSet(JsonNode approverJsonNode) {
        if (approverJsonNode == null) {
            return null;
        }
        Set<String> userSet = new HashSet<>();
        Iterator<JsonNode> jsonNodeIterator = approverJsonNode.get("text").elements();
        while (jsonNodeIterator.hasNext()) {
            JsonNode userJsonNode = jsonNodeIterator.next();
            userSet.add(userJsonNode.get("id").textValue());
        }
        return userSet;
    }
}
