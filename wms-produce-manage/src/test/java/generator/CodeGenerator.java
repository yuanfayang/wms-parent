package generator;

import com.deer.wms.project.seed.generator.Generator;
import com.deer.wms.project.seed.generator.configurer.DatasourceConfigurer;
import com.deer.wms.project.seed.generator.configurer.Table;

/**
 * Created by Floki on 2017/9/29.
 */
public class CodeGenerator {
    public static void main(String[] args) {
        DatasourceConfigurer configurer = new DatasourceConfigurer();
        //璁剧疆鏁版嵁搴撹繛鎺ヤ俊鎭
        configurer.setUrl("jdbc:mysql://47.96.183.77:3306/mt_erp?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false");
        configurer.setUserName("root");
        configurer.setPassword("mt_%wms#_CS_20190430");
        configurer.setDiverClassName("com.mysql.jdbc.Driver");

        //璁剧疆闇€瑕佺敓鎴愪唬鐮佺殑鍩虹璺緞锛岀敓鎴愮殑浠ｇ爜閮戒細鍦ㄨ璺緞涓嬮潰
        configurer.setBasePackage("com.deer.wms.produce.manage");
        configurer.setAuthor("");

        //璁剧疆瀛愭ā鍧楀悕绉濡傛灉瑕佺敓鎴愬瓙妯″潡鐨勪唬鐮侊紝涓€瀹氳璁剧疆璇ュ€硷紝鍚﹀垯浠ｇ爜灏嗕細鐢熸垚鍒扮埗椤圭洰涓簡)
        configurer.setModuleName("/wms-produce-manage");

        //璁剧疆闇€瑕佺敓鎴愮殑琛
        configurer.getTables().add(new Table("mt_alone_process_batch_relat", null, "id", "Integer"));
        configurer.getTables().add(new Table("mt_alone_product_batch_detect", null, "id", "Integer"));
        configurer.getTables().add(new Table("mt_alone_product_batch_detect_det", null, "id", "Integer"));

        //鐢熸垚浠ｇ爜
        Generator.genCode(configurer);
    }
}
