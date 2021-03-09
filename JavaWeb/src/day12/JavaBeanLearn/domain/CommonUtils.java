package day12.JavaBeanLearn.domain;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

public class CommonUtils {


    /**
     * 生成不重复的32为的大写字符串
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }


    /**
     * 把Map转换成指定类型的JavaBean对象
     * @param map
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T toBean(Map map, Class<T> tClass){
        try{
            //创建指定类型的JavaBean对象
            T bean = tClass.newInstance();

            //把数据封装到javaBean
            BeanUtils.populate(bean,map);

            //返回JavaBean对象
            return bean;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
