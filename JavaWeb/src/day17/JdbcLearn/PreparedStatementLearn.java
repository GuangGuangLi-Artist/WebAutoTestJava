package day17.JdbcLearn;

import org.junit.Test;

import java.sql.*;

public class PreparedStatementLearn {

    /**
     * 使用username和password去查询数据
     * 若查出结果集，说明正确！返回true
     * 若查出不出结果，说明用户名或密码错误，返回false
     */
    public boolean login(String username,String password) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/author_book?serverTimezone=GMT","liguang","123456");

        Statement statement = connection.createStatement();
        String sql = "select * from user where username='" + username +"' and password='" + password + "'";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.next();
    }

    @Test
    public void fun1() throws SQLException {

        /**
         * sql注入
         */
        String username = "a' or 'a' = 'a";
        String password = "a' or 'a' = 'a";
        //boolean bool =login("zhangsan","123");
        boolean bool =login(username,password);
        System.out.println(bool);
    }

    public  boolean login2(String username,String password) throws SQLException {
        /*
         * 一、得到PreparedStatement
         * 1. 给出sql模板：所有的参数使用?来替代
         * 2. 调用Connection方法，得到PreparedStatement
         */

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/author_book?serverTimezone=GMT","liguang","123456");
        String sql = "select * from user where username=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //为参数赋值
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();

//        preparedStatement.setString(1,"zhangsan");
//        preparedStatement.setString(2,"123456");
//        preparedStatement.executeQuery();
        return resultSet.next();
    }


    @Test
    public void fun2() throws SQLException {

        /**
         * sql注入
         */
        String username = "a' or 'a' = 'a";
        String password = "a' or 'a' = 'a";
        //boolean bool =login2("zhangsan","123");
        //boolean bool =login2(username,password);
        boolean bool = login2("zhangsan","123");
        System.out.println(bool);
    }

}
