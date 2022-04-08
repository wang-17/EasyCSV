package test;

import com.xykj.easycsv.listener.CsvListener;

import java.util.Map;

public class OwidListener implements CsvListener<OwidEntity> {

    int i=0;
    @Override
    public void invoke(OwidEntity data, String sourceColumn) {
        i++;
        System.out.println("读取第"+i+"条数据:"+data);
    }

    @Override
    public void invokeHead(Map<String, Integer> titleIndexMap, String sourceColumn) {
        System.out.println(titleIndexMap);
    }

    @Override
    public void onError(Exception e,String sourceColumn) {

    }

    @Override
    public void readOver() {
        System.out.println("所有数据读取完毕");
    }
}
