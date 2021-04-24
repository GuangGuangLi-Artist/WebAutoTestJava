package day17.cn.itcast.usermng.dao;

import day17.cn.itcast.usermng.domain.User;

public interface UserDao {
    public void addUser(User form);
    public User findByUsername(String username);

}
