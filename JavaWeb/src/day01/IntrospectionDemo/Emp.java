package day01.IntrospectionDemo;

import java.util.Date;

public class Emp {

    private int id;

    private  String name;

    private double salry;

    private Date birthday;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalry() {
        return salry;
    }

    public void setSalry(double salry) {
        this.salry = salry;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Emp() {
    }

    public Emp(int id, String name, double salry, Date birthday) {
        this.id = id;
        this.name = name;
        this.salry = salry;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  "编号: " + id +  " 姓名:" + name  + " 薪水: "+ salry + " 生日: " + birthday;
    }


}
