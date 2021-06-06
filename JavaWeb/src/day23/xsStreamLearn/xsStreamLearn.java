package day23.xsStreamLearn;

import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class xsStreamLearn {

    //返回javabean集合
    public List<Province> getProvinceList(){

        Province p1 = new Province();
        p1.setName("北京");
        p1.addCity(new City("东城区","DongChengQu"));
        p1.addCity(new City("西城区","XiChengQu"));

        Province p2 = new Province();
        p2.setName("甘肃");
        p2.addCity(new City("兰州","LanZhou"));
        p2.addCity(new City("定西","DingXi"));

        List<Province> provinceList = new ArrayList<>();
        provinceList.add(p1);
        provinceList.add(p2);

        return provinceList;

    }

    /**
     * <list>List类型显示list
     *   <day23.xsStreamLearn.Province>javabean的类型为Province，它元素的名称为类的完整名
     *     <name>北京</name>javabean的属性名
     *     <cities>javabean的属性名
     *       <day23.xsStreamLearn.City>类名
     *         <name>东城区</name>属性名
     *         <description>DongChengQu</description>属性名
     *       </day23.xsStreamLearn.City>
     *       <day23.xsStreamLearn.City>
     *         <name>西城区</name>
     *         <description>XiChengQu</description>
     *       </day23.xsStreamLearn.City>
     *       <day23.xsStreamLearn.City>
     *         <name>兰州</name>
     *         <description>LanZhou</description>
     *       </day23.xsStreamLearn.City>
     *       <day23.xsStreamLearn.City>
     *         <name>定西</name>
     *         <description>DingXi</description>
     *       </day23.xsStreamLearn.City>
     *     </cities>
     *   </day23.xsStreamLearn.Province>
     *   <day23.xsStreamLearn.Province>
     *     <name>甘肃</name>
     *     <cities/>
     *   </day23.xsStreamLearn.Province>
     * </list>
     */

    @Test
    public void fun1(){
        List<Province> provList = getProvinceList();
        /*
        创建XStream对象
        调用toXML方法把集合转换成字符串
         */
        XStream xStream = new XStream();
        String s = xStream.toXML(provList);
        System.out.println(s);

    }

    /*
     * 别名(alias)
     * 希望：
     * * 默认List类型对应<list>元素，希望让List类型对应<china>元素
     * * 默认Province类型对应<cn.itcast.demo1.Province>，希望让它对应<province>
     * * 默认City类型对应<cn.itcast.demo1.City>，希望它对应<city>元素
     */

    /**
     * <china>
     *   <province>
     *     <name>北京</name>
     *     <cities>
     *       <city>
     *         <name>东城区</name>
     *         <description>DongChengQu</description>
     *       </city>
     *       <city>
     *         <name>西城区</name>
     *         <description>XiChengQu</description>
     *       </city>
     *       <city>
     *         <name>兰州</name>
     *         <description>LanZhou</description>
     *       </city>
     *       <city>
     *         <name>定西</name>
     *         <description>DingXi</description>
     *       </city>
     *     </cities>
     *   </province>
     *   <province>
     *     <name>甘肃</name>
     *     <cities/>
     *   </province>
     * </china>
     */
    @Test
    public void fun2(){
        List<Province> provinceList = getProvinceList();

        XStream xStream = new XStream();
        //指定的类型指定别名
        xStream.alias("china",List.class);
        xStream.alias("province",Province.class);
        xStream.alias("city",City.class);

        String s = xStream.toXML(provinceList);
        System.out.println(s);
    }

    //默认javabean的属性都会生成子元素，而现在希望生成元素的属性


    /**
     * <china>
     *   <province name="北京">
     *     <cities>
     *       <city>
     *         <name>东城区</name>
     *         <description>DongChengQu</description>
     *       </city>
     *       <city>
     *         <name>西城区</name>
     *         <description>XiChengQu</description>
     *       </city>
     *       <city>
     *         <name>兰州</name>
     *         <description>LanZhou</description>
     *       </city>
     *       <city>
     *         <name>定西</name>
     *         <description>DingXi</description>
     *       </city>
     *     </cities>
     *   </province>
     *   <province name="甘肃">
     *     <cities/>
     *   </province>
     * </china>
     */
    @Test
    public void fun3(){
        List<Province> provinceList = getProvinceList();

        XStream xStream = new XStream();
        //指定的类型指定别名
        xStream.alias("china",List.class);
        xStream.alias("province",Province.class);
        xStream.alias("city",City.class);

        //把Province类型的name属性，生成<province>元素的属性
        xStream.useAttributeFor(Province.class,"name");

        String s = xStream.toXML(provinceList);
        System.out.println(s);




    }

    /**
     <china>
     <province name="北京">
     <city>
     <name>东城区</name>
     <description>DongChengQu</description>
     </city>
     <city>
     <name>西城区</name>
     <description>XiChengQu</description>
     </city>
     </province>
     <province name="甘肃">
     <city>
     <name>兰州</name>
     <description>LanZhou</description>
     </city>
     <city>
     <name>定西</name>
     <description>DingXi</description>
     </city>
     </province>
     </china>
     */



    //去除List类型的属性，只把list中的元素生成xml元素

    @Test
    public void fun4(){
        List<Province> provinceList = getProvinceList();

        XStream xStream = new XStream();
        //指定的类型指定别名
        xStream.alias("china",List.class);
        xStream.alias("province",Province.class);
        xStream.alias("city",City.class);
        xStream.useAttributeFor(Province.class,"name");

        //去除<cities>这样的Collection类型的属性
        //去除Provice类的名为cities的List类型的属性！
        xStream.addImplicitCollection(Province.class,"cities");

        String s = xStream.toXML(provinceList);
        System.out.println(s);
    }


     //去除不想要的javabean属性
	 //就是让某引起javabean属性，不生成对应的xml元素！

    /**
     * <china>
     *   <province name="北京">
     *     <city>
     *       <name>东城区</name>
     *     </city>
     *     <city>
     *       <name>西城区</name>
     *     </city>
     *   </province>
     *   <province name="甘肃">
     *     <city>
     *       <name>兰州</name>
     *     </city>
     *     <city>
     *       <name>定西</name>
     *     </city>
     *   </province>
     * </china>
     */
    @Test
    public void fun5(){
        List<Province> provinceList = getProvinceList();

        XStream xStream = new XStream();
        //指定的类型指定别名
        xStream.alias("china",List.class);
        xStream.alias("province",Province.class);
        xStream.alias("city",City.class);
        xStream.useAttributeFor(Province.class,"name");
        xStream.addImplicitCollection(Province.class,"cities");
        xStream.omitField(City.class,"description");//让City类的，名为description属性不生成对应的xml元素

        String s = xStream.toXML(provinceList);
        System.out.println(s);





    }
}
