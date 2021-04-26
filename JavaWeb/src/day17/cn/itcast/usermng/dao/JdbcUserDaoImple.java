package day17.cn.itcast.usermng.dao;

import day17.JdbcLearn.JdbcUtils;
import day17.cn.itcast.usermng.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDaoImple implements UserDao {
    @Override
    public void addUser(User form) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;



        try {
            //得到连接
            connection = JdbcUtils.getConnection();
            //准备sql模板，得到preparedStatement
            String sql = "INSERT INTO user VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            //为preparedStatement中的问号赋值
            preparedStatement.setString(1,form.getUsername());
            preparedStatement.setString(2,form.getPassword());
            preparedStatement.setInt(3,form.getAge());
            preparedStatement.setString(4,form.getGender());

            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){

            }
        }
    }


    @Override
    public User findByUsername(String username) {
        //得到连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            //得到连接
            connection = JdbcUtils.getConnection();

            //准备sql模板
            String sql =  "SELECT * FROM user WHERE username=?";
            preparedStatement = connection.prepareStatement(sql);

            //为preparedStatement中的问号赋值
            preparedStatement.setString(1,username);

            //执行
            resultSet = preparedStatement.executeQuery();

            //把resultSet转换成user类型，返回
            if(resultSet == null){
                return null;
            }
            if(resultSet.next()){
                //转换成User对象，并返回
                //ORM --> 对象关系映射
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }catch (SQLException e){ }
        }
    }
}
