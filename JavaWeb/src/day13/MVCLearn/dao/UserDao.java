package day13.MVCLearn.dao;

import day13.MVCLearn.domain.User;

/**
 * 把xml中的数据铲鲟出来之后，封装到user对象中，然后返回
 */

public class UserDao {
    public User find(){
        return new User("李广","123");
    }
}
