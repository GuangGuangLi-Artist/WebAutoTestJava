package day12.JavaBeanLearn.domain;

public class Person {

    /**
     * 必须要为成员提供get/set方法(两者提供一个也是可以的)
     * 必须要有默认构造器
     * 一般对于具有get.set方法的成员变量称之为属性
     *
     * 其实就算一个属性没有对应的成员变量，只有get/set方法也是可以的
     *  属性的名称就是get/set方法去除get/set后，再把首字母小写了
     */
    public String name;
    public int age;
    public String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }

    public Person(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
