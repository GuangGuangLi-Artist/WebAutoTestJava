package day23.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day23JsonLearn1 {

    @Test
    public void fun1(){
        JSONObject map = new JSONObject();
        map.put("name","liguang");
        map.put("age",18);
        map.put("sex","male");

        String s = map.toString();
        //{"name":"liguang","age":18,"sex":"male"}
        System.out.println(s);
    }

    //当你有一个Person对象时，可以把person转换成JsonObject对象

    @Test
    public void fun2(){
        Day23Person person = new Day23Person("liguang",23,"male");
        JSONObject jsonObject = JSONObject.fromObject(person);
        //{"age":23,"name":"liguang","sex":"male"}
        System.out.println(jsonObject);
    }

    //JsonArray
    @Test
    public void fun3(){
        Day23Person person = new Day23Person("liguang",23,"male");
        Day23Person day23Person = new Day23Person("huahua",23,"female");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(person);
        jsonArray.add(day23Person);
        //[{"age":23,"name":"liguang","sex":"male"},{"age":23,"name":"huahua","sex":"female"}]
        System.out.println(jsonArray.toString());
    }

    //把list转化成JsonArray
    @Test
    public void fun4(){
        Day23Person day23Person = new Day23Person("ceshi",34,"male");
        Day23Person day23Person2 = new Day23Person("xuexi",32,"male");
        List<Day23Person> list = new ArrayList<>();
        list.add(day23Person);
        list.add(day23Person2);

        //[{"age":34,"name":"ceshi","sex":"male"},{"age":32,"name":"xuexi","sex":"male"}]
        System.out.println(JSONArray.fromObject(list).toString());
    }
}
