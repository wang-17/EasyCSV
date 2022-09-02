package test;

import com.xykj.easycsv.EasyCsv;
import com.xykj.easycsv.entity.CsvProperty;
import com.xykj.easycsv.entity.IgnoreField;

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
        //创建监听器实例
        StudentListener studentListener = new StudentListener();
        //执行监听器读方法
        new EasyCsv().doRead("C:\\Users\\it\\Documents\\WXWork\\1688857922266493\\Cache\\File\\2022-04\\test.csv"
                ,Student.class,studentListener);
        //获取读到的数据
        List<Student> dataList = studentListener.dataList;
    }


    /**
     * 测试自定义规则
     */
    public static void testRule(){

        List<Student> students = new EasyCsv().readAll("C:\\Users\\it\\Documents\\WXWork\\1688857922266493\\Cache\\File\\2022-04\\测试.csv"
                , Student.class);
        System.out.println(students);
    }


    /**
     * 写CSV测试方法
     * @param students 即将写入的数据列表
     */
    public void testWrite(List<Student> students){
        String outPath="C:\\Users\\DJ033019\\Desktop\\temp\\out_test.csv";
        new EasyCsv().write(outPath,students);
    }


    public static void main(String[] args) {
        EasyCsv easyCsv = new EasyCsv();
        String path="C:\\Users\\DJ033019\\Desktop\\test.csv";
        String outPath="C:\\Users\\DJ033019\\Desktop\\temp\\out_test.csv";
        List<Student> students =easyCsv.readAll(path, Student.class);
        System.out.println(students);
        easyCsv.write(outPath,students);

    }


}
