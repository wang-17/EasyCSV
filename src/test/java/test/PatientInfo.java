package test;

import com.xykj.easycsv.entity.CsvProperty;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
