package test;

import com.xykj.easycsv.entity.CsvProperty;
import lombok.Data;

@Data
public class Student {
    @CsvProperty("no")
    String no;
    @CsvProperty("name")
    String name;
    @CsvProperty("age")
    int age;
}
