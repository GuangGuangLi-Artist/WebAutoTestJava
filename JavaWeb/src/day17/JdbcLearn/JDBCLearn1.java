package day17.JdbcLearn;

import org.junit.Test;

import java.sql.*;

public class JDBCLearn1 {

    @Test
    public void fun1() throws ClassNotFoundException, SQLException {
        /**
         * jdbc四大配置参数
         * driverClassName:com.mysql.jdbc.driver
         * url:jdbc:mysql://localhost:3306/mydb3
         * username:root
         * password:123
         */

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/author_book?serverTimezone=GMT";
        String username = "liguang";
        String password = "123456";

        Connection con = DriverManager.getConnection(url,username,password);
        System.out.println(con);

        //得到statement对象
        Statement statement =  con.createStatement();

        //编写sql
//        String sql  = "insert  into  tbl_authors values('8','天下霸唱','123@qq.com')";
//        String sql = "update tbl_authors set  name='猫九' where id='8'";
        String sql = "delete from tbl_authors where id='8'";
        int r = statement.executeUpdate(sql);
        System.out.println(r);


    }

    @Test
    public void fun2() throws SQLException {
        //连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/author_book?serverTimezone=GMT","liguang","123456");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select  * from tbl_authors");
        System.out.println(resultSet);
        //解析resultSet
        while (resultSet.next()){//把光标向下移动一行,并判断下一行是否存在
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println(id + "," + name + "," + email);
        }

        //关闭资源  倒关
        resultSet.close();
        statement.close();
        connection.close();//
    }

    //标准化代码

    @Test
    public void fun3() throws Exception{
        //声明对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //创建连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/author_book?serverTimezone=GMT","liguang","123456");
            statement = connection.createStatement();
            String sql = "select  * from tbl_authors";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + "," + resultSet.getString("name") + "," + resultSet.getString("email"));
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        finally {
            //关闭
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) connection.close();

        }

    }
}
