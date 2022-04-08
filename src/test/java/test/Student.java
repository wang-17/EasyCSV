package test;

import com.xykj.easycsv.entity.CsvProperty;
import lombok.Data;

@Data
public class Student {
    @CsvProperty( index = 0)
    String no;
    @CsvProperty(index = 1)
    String name;
    @CsvProperty(index = 2)
    int age;
}
