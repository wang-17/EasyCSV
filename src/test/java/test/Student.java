package test;

import com.xykj.easycsv.entity.CsvProperty;
import com.xykj.easycsv.entity.IgnoreField;

public class Student{
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
