package test;

import com.xykj.easycsv.EasyCsv;
import com.xykj.easycsv.entity.Rule;

import java.util.List;

public class TestEasyCsv {

    public static String fileName="C:\\Users\\it\\Desktop\\北京周报临时数据\\owid_covid_data_2022-02-28.csv";

    /**
     * 读取全量数据测试
     */
    public static void readAllTest(){
        final List<OwidEntity> all = new EasyCsv().readAll(fileName, OwidEntity.class);
        System.out.println("======================");
        for (OwidEntity owidEntity : all.subList(0, 20)) {
            System.out.println(owidEntity);
        }
    }

    /**
     * 重写监听器的方式运行
     */
    public static void testDoRead(){
        new EasyCsv().doRead("C:\\Users\\it\\Documents\\WXWork\\1688857922266493\\Cache\\File\\2022-04\\住院三年.csv"
                ,PatientInfo.class,new PatientInfoListener());
    }


    /**
     * 测试自定义规则
     */
    public static void testRule(){

        final List<Student> students = new EasyCsv().readAll("C:\\Users\\it\\Documents\\WXWork\\1688857922266493\\Cache\\File\\2022-04\\测试.csv"
                , Student.class);
        System.out.println(students);
    }


    public static void main(String[] args) {
        readAllTest();
    }


}
