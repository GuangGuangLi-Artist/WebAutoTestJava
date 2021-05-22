package day20.ListenerLearn;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Day20Uesr implements HttpSessionBindingListener {
    private String name;
    private String password;

    @Override
    public String toString() {
        return "Day20Uesr{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Day20Uesr() {
    }

    public Day20Uesr(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("啊 ，Session添加了我");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("啊，无情的Session抛弃了我");

    }
}
