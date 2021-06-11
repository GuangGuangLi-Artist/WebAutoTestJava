package day27.InterfaceOriented.Day27Domain;

public class Day27Teacher {
    private String tid;
    private String name;
    private double salary;

    @Override
    public String toString() {
        return "Day27Teacher{" +
                "tid='" + tid + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Day27Teacher() {
    }

    public Day27Teacher(String tid, String name, double salary) {
        this.tid = tid;
        this.name = name;
        this.salary = salary;
    }
}
