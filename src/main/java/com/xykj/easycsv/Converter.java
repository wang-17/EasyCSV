package com.xykj.easycsv;

import com.xykj.easycsv.entity.CsvProperty;
import com.xykj.easycsv.entity.Rule;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 转化器
 */
@Slf4j
public class Converter {

    /**
     * 分割工具
     * 分割工具
     */
    private Rule rule;

    public Converter(Rule rule) {
        this.rule = rule;
    }

    public Converter() {
        this.rule = null;
    }



    /**
     * 标题名-标题index
     */
    private Map<String,Integer> titleIndexMap =new HashMap<>();

    /**
     * 标题名-实体类属性名
     */
    Map<String, String> titleFieldMap=null;

    public Map<String, Integer> getTitleIndexMap() {
        return titleIndexMap;
    }

    public Map<String, String> getTitleFieldMap() {
        return titleFieldMap;
    }

    public void setTitleIndexMap(String titleColumn){
        String[] strList = getStrList(titleColumn);
        for (int i = 0; i < strList.length; i++) {
            String title = strList[i];
            titleIndexMap.put(title,i);
        }
    }

    /**
     * 获取一个标题-参数名map
     * @param a
     * @param <T>
     * @return
     */
    public <T> Map<String,String> getTitleFieldMap(Class<T> a){
        Map<String,String> exprMap=new HashMap<>();
        if (this.titleFieldMap!=null){
            return titleFieldMap;
        }
        for (Field field : a.getDeclaredFields()) {
            CsvProperty annotation = field.getAnnotation(CsvProperty.class);
            String titleName = annotation.value();
            String name = field.getName();
            exprMap.put(name,titleName);
        }
        this.titleFieldMap=exprMap;
        return exprMap;
    }

    /**
     * 获取一个实例
     * @param str
     * @param classA
     * @param <T>
     * @return
     */
    public  <T> T getT(String str,Class<T> classA) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        String[] cells = getStrList(str);
        final Map<String, String> titleFieldMap = getTitleFieldMap(classA);
        return getT(cells,classA,titleFieldMap);
    }

    public Map<Integer,String> getMap(String str){
        String[] cells = getStrList(str);
        Map<Integer,String> result=new LinkedHashMap<>();
        for (int i = 0; i < cells.length; i++) {
            result.put(i,cells[i]);
        }
        return result;
    }

    /**
     * 获取一条实例
     * @param cells  一行数据
     * @param a  返回对象的类型
     * @param titleFieldMap  标题-参数map  参数为对象的参数
     * @param <T>
     * @return
     */
    private  <T> T getT(String[] cells, Class<T> a,Map<String, String> titleFieldMap) throws InstantiationException, IllegalAccessException, InvocationTargetException {
            T result = a.newInstance();
            Method[] methods = a.getMethods();
            for (Method method : methods) {
                if (!method.getName().contains("set")){continue;}
                String fieldName = getFieldName(method);
                String title = titleFieldMap.get(fieldName);
                if (title!=null){
                    String cellValue = getCellByTitle(title, cells);
                    if (cellValue!=null){
                        Class<?> parameterType = method.getParameterTypes()[0];
                        Object value = parseValue(parameterType, cellValue);
                        if (value!=null){
                            method.invoke(result,value);
                        }
                    }
                }
            }
            return result;
    }

    /**
     *
     * @param title
     * @param cells
     * @return
     */
    public String getCellByTitle(String title,String[] cells){
        Integer index = titleIndexMap.get(title);
        if (index!=-1){
            return cells[index];
        }
        return null;
    }

    private String split=null;

    /**
     * 将一整行字符串分割成一个个单元格
     * @param str
     * @return
     */
    private String[] getStrList(String str){
        if (rule!=null){
            if (split==null){
                String startWith = rule.getStartWith();
                String endWith = rule.getEndWith();
                String split = rule.getSplit();
                this.split=endWith + split + startWith;
            }
            String[] split1 = str.split(this.split);
            String first = split1[0];
            String last = split1[split1.length-1];
            split1[0]=first.replaceFirst(rule.getStartWith(),"");
            split1[split1.length-1]=last.substring(0,last.lastIndexOf(rule.getEndWith()));
            return split1;
        }
        return str.split(",");
    }

    /**
     * 获取参数名称
     * @param method
     * @return
     */
    public String getFieldName(Method method){
        String name = method.getParameters()[0].getName();
        return name;
    }


    /**
     * 将表格的值转换成对象属性的类型
     * @param parameterType
     * @param cellValue
     * @return
     */
    public Object parseValue(Class<?> parameterType,String cellValue){
//        String parameterTypeStr = parameterType.toString();
        Object result=null;
        try {
            if (parameterType.equals(BigDecimal.class)){
            }else if (cellValue==null){
                log.info("一条空值");
            }else if (parameterType.equals(String.class)){
                result=cellValue;
            }else if (parameterType.equals(Integer.class)|| "int".equals(parameterType.getName())){
                result= parseInt(cellValue);
            }else if (parameterType.equals(Float.class)|| "float".equals(parameterType.getName())){
                result=parseFloat(cellValue);
            }else if (parameterType.equals(Double.class)|| "double".equals(parameterType.getName())){
                result=parseDouble(cellValue);
            }else if (parameterType.equals(Long.class)|| "long".equals(parameterType.getName())){
                result=parseLong(cellValue);
            }else if (parameterType.equals(Short.class)|| "short".equals(parameterType.getName())){
                result=parseShort(cellValue);
            }else if (parameterType.equals(Boolean.class)|| "boolean".equals(parameterType.getName())){
                result=Boolean.parseBoolean(cellValue);
            }else if (parameterType.equals(Character.class)||"char".equals(parameterType.getName())){
                result=cellValue.charAt(0);
            }
        }catch (Exception e){
            log.error("类型转换异常-无法将值‘"+cellValue+"’转换成‘"+parameterType+"’类型:{}",e);
        }
        return result;
    }

    private int parseInt(String value){
        if (value==null||"".equals(value)){
            return 0;
        }
        return new BigDecimal(value).intValue();
    }
    private float parseFloat(String value){
        if (value==null||"".equals(value)){
            return 0;
        }
        return new BigDecimal(value).floatValue();
    }
    private long parseLong(String value){
        if (value==null||"".equals(value)){
            return 0;
        }
        return new BigDecimal(value).longValue();
    }
    private double parseDouble(String value){
        if (value==null||"".equals(value)){
            return 0;
        }
        return new BigDecimal(value).doubleValue();
    }
    private short parseShort(String value){
        if (value==null||"".equals(value)){
            return 0;
        }
        return new BigDecimal(value).shortValue();
    }
}
