import com.deer.wms.project.seed.util.MD5Utils;

public class TestMd5 {

    public static void main(String[] args){
        System.out.println("aaa");
        String psw = MD5Utils.encryptPassword("过团挺","123","124");
        System.out.println(psw);
    }
}
