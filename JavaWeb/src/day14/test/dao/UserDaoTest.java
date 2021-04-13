package day14.test.dao;

import day14.cn.itcast.user.dao.UserDao;
import day14.cn.itcast.user.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testFindByUsername(){
        UserDao userDao = new UserDao();
        User user= userDao.findByUsername("李四");
        System.out.println(user);
    }

    @Test
    public void testAdd(){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("tianxia");
        user.setPassword("4123");
        userDao.addUser(user);
    }
}
