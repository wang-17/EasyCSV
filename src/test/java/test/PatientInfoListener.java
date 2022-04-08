package test;

import com.xykj.easycsv.listener.CsvListener;

import java.util.Map;

public class PatientInfoListener implements CsvListener<PatientInfo> {
    private int i=0;
    @Override
    public void invoke(PatientInfo data, String sourceColumn) {
        i++;
        System.out.println("读取第"+i+"条数据:"+data);
    }

    @Override
    public void invokeHead(Map<String, Integer> titleIndexMap, String sourceColumn) {
        System.out.println(titleIndexMap);
    }

    @Override
    public void onError(Exception e,String sourceColumn) {
//        System.out.println("错误行："+i+"="+sourceColumn);
    }

    @Override
    public void readOver() {
        System.out.println("读取完毕");
    }
}
