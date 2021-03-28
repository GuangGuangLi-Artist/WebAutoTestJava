package day13.MVCLearn.service;

import day13.MVCLearn.dao.UserDao;
import day13.MVCLearn.domain.User;

public class UserService {
    //service层依赖dao层
    private UserDao userDao = new UserDao();

    //service的查询，需要使用dao来完成
    public User find(){
        return userDao.find();
    }

}
