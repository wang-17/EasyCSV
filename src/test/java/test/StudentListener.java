package test;

import com.xykj.easycsv.listener.CsvListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentListener implements CsvListener<Student> {


    public List<Student> dataList=new ArrayList<>();



    /**
     *
     * @param data  实例化后的对象
     * @param sourceColumn 源数据行字符串
     */
    @Override
    public void invoke(Student data, String sourceColumn) {
        dataList.add(data);
    }

    /**
     * 初始化标题
     * @param titleIndexMap
     * @param sourceColumn
     */
    @Override
    public void invokeHead(Map<String, Integer> titleIndexMap, String sourceColumn) {
        System.out.println(titleIndexMap);
    }

    /**
     * 当出现错误行时
     * @param e
     * @param sourceColumn
     */
    @Override
    public void onError(Exception e,String sourceColumn) {
//        System.out.println("错误行："+i+"="+sourceColumn);
    }

    /**
     * 读数据完毕
     */
    @Override
    public void readOver() {
        System.out.println("读取完毕");
    }
}
