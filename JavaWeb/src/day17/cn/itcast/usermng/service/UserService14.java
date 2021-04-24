package day17.cn.itcast.usermng.service;

import day17.cn.itcast.usermng.dao.DaoFactory;
import day17.cn.itcast.usermng.dao.UserDao;
import day17.cn.itcast.usermng.domain.User;

/**
 * User的业务层
 */

public class UserService14 {

    //把具体的实现类的创建，隐藏到工程
    private UserDao userDao = DaoFactory.getUserDao();

    public void register(User user) throws UserException {
        /**
         * 使用用户名去查询，如果返回null,完成添加
         * 如果返回的不是null,抛出异常
         */

        User _user  = userDao.findByUsername(user.getUsername());
        if(_user != null) throw new UserException("用户名" + user.getUsername() + ", 已被注册过了");

        userDao.addUser(user);
    }

    /**
     * 登录功能
     *
     */
    public User login(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());

        if(user == null) throw new UserException("用户名不存在");

        if(!form.getPassword().equals(user.getPassword())){
            throw new UserException("密码错误！");
        }

        return user;

    }

}
