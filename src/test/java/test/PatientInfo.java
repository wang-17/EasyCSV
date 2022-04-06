package test;

import com.xykj.easycsv.entity.CsvProperty;
import lombok.Data;

@Data
public class PatientInfo {
    @CsvProperty("就诊原因名称")
    private String reason;
    @CsvProperty("就诊日期")
    private String date;
    @CsvProperty("纬度")
    private String latitude;
    @CsvProperty("经度")
    private String  longitude;
    @CsvProperty("地址")
    private String adress;
}
