package test;

import com.xykj.easycsv.EasyCsv;
import com.xykj.easycsv.entity.CsvProperty;
import com.xykj.easycsv.entity.IgnoreField;
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

    public static class Student{
        @CsvProperty("学号")
        private int no;
        @CsvProperty("姓名")
        private String name;
        @CsvProperty("年龄")
        private Integer age;
        @IgnoreField
        private Integer testFileld;

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", testFileld=" + testFileld +
                    '}';
        }
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
