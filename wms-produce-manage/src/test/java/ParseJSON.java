
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deer.wms.produce.manage.model.*;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hy
 * @Date: 2019/9/21 16:02
 * @Version 1.0
 */
public class ParseJSON {

    public static void main(String[] args){
        MaterialsOutgoingLogVo materialsInfo = new MaterialsOutgoingLogVo();
        List l = new ArrayList();
        l.add(materialsInfo);
        String s = JSON.toJSONString(l, SerializerFeature.PrettyFormat,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullBooleanAsFalse,SerializerFeature.WriteNullNumberAsZero);
        System.out.println(s);
    }

}
