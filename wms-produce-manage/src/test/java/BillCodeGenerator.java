import com.deer.wms.project.seed.generator.Generator;
import com.deer.wms.project.seed.generator.configurer.DatasourceConfigurer;
import com.deer.wms.project.seed.generator.configurer.Table;

/**
 * Created by Floki on 2017/9/29.
 */
public class BillCodeGenerator {
    public static void main(String[] args) {
        DatasourceConfigurer configurer = new DatasourceConfigurer();
        //设置数据库连接信息
        configurer.setUrl("jdbc:mysql://47.96.183.77:3306/mt_erp?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false");
        configurer.setUserName("root");
        configurer.setPassword("mt_%wms#_CS_20190430");
        configurer.setDiverClassName("com.mysql.jdbc.Driver");

        //设置需要生成代码的基础路径，生成的代码都会在该路径下面
        configurer.setBasePackage("com.deer.wms.ware.task");
        configurer.setAuthor("guo");

        //设置子模块名称(如果要生成子模块的代码，一定要设置该值，否则代码将会生成到父项目中了)
        configurer.setModuleName("/wms-ware-task");

        //设置需要生成的表
         configurer.getTables().add(new Table("mt_alone_materials_info",null,"id","Integer"));

        configurer.getTables().add(new Table("mt_alone_product_process_bom",null,"id","Integer"));

        configurer.getTables().add(new Table("mt_alone_process_bom",null,"id","Integer"));
        //生成代码
        Generator.genCode(configurer);
    }
}
