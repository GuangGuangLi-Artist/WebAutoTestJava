package day01.CollectionsDemo;

import java.util.*;

public class CollectionsReview {

    public static void main(String[] args) {
        HashSet<Person> hs = new HashSet<>();

        hs.add(new Person(25,"苏彪"));
        hs.add(new Person(25,"苏彪"));

        System.out.println("集合的元素" + hs);

        System.out.println("----集合的遍历----");

        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i) + ",");
        }


        System.out.println("\r\n----迭代器遍历-----");

        HashSet<String> set = new HashSet<>();
        set.add("haha");
        set.add("hehe");
        set.add("keke");


        Iterator<String> it = set.iterator();//获取到迭代器
        while (it.hasNext()){
            System.out.print(it.next() + ",");
        }


        System.out.println("\r\n------entrySet方式遍历-------");

        HashMap<Integer,String> map = new HashMap<>();
        map.put(11,"铁蛋");
        map.put(12,"狗蛋");
        map.put(13,"傻蛋");

        Set<Map.Entry<Integer,String>> entrys = map.entrySet();
        for(Map.Entry<Integer,String> entry:entrys){
            System.out.println("键: " + entry.getKey() + " 值：" + entry.getValue());
        }



    }

}

class Person{

    int age;
    String name;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }



    public Person() {
    }

    @Override
    public String toString() {
        return "年龄:" + this.age + " 姓名：" + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
