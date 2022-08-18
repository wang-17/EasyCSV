package test;

import com.xykj.easycsv.entity.CsvProperty;

public class Student {
    @CsvProperty( index = 0)
    String no;
    @CsvProperty(index = 1)
    String name;
    @CsvProperty(index = 2)
    int age;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
