package com.deer.wms.workflow.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * JsonToObjectUtil
 *
 * @author luxin.yan
 * @date 2019/1/10
 **/
public class JsonToObjectUtil {
    public static Map<String, Object> jsonToMap(String json) {
        return jsonToMap(json, true);
    }

    /**
     * 讲json转成map对象
     *
     * @param json
     * @return
     */
    public static Map<String, Object> jsonToMap(String json, boolean isForeach) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(json.getBytes("UTF-8"));
        } catch (IOException e) {
            return null;
        }
        Map<String, Object> data = new HashMap<>();
        foreachJsonNode(data, jsonNode, isForeach);
        return data;
    }

    private static void foreachJsonNode(final Map<String, Object> data, JsonNode jsonNode, boolean isForeach) {
        Iterator<String> keys = jsonNode.fieldNames();
        while (keys.hasNext()) {
            String key = keys.next();
            JsonNode jsonNode1 = jsonNode.get(key);
            boolean hashChild = false;
            Iterator<String> keys_1 = jsonNode1.fieldNames();
            if (keys_1.hasNext()) {
                hashChild = true;
                if (isForeach) {
                    foreachJsonNode(data, jsonNode1, isForeach);
                } else {
                    data.put(key, jsonNode1.toString());
                }
            }
            if (!hashChild) {
                if (StringUtils.isNotBlank(jsonNode1.textValue())) {
                    data.put(key, jsonNode1.textValue());
                } else {
                    data.put(key, jsonNode1.asText());
                }
            }
        }
    }

    /**
     * 直转一级json
     *
     * @return
     */
    public static Map<String, String> jsonToMapOne(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json.getBytes("UTF-8"));
        Map<String, String> data = new HashMap<>(5);
        Iterator<String> keys = jsonNode.fieldNames();
        while (keys.hasNext()) {
            String key = keys.next();
            JsonNode jsonNode1 = jsonNode.get(key);
            if (StringUtils.isNotBlank(jsonNode1.textValue())) {
                data.put(key, jsonNode1.textValue());
            } else {
                if (StringUtils.isNotBlank(jsonNode1.asText())) {
                    data.put(key, jsonNode1.asText());
                } else {
                    data.put(key, jsonNode1.toString());
                }
            }

        }
        return data;
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"name\": \"zhangquan\",\n" +
                "    \"description\": \"1111111\",\n" +
                "    \"type\": 0,\n" +
                "    \"templateJson\": {\"a\":1},\n" +
                "    \"fileId\": \"\"\n" +
                "  }";
        Map<String, Object> data = jsonToMap(json, false);
        System.out.println(data.get("templateJson"));
    }
}
