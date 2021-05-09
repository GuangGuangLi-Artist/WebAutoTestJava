package day18.c3p0Learn;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Learn {

    @Test
    public void fun1() throws SQLException, PropertyVetoException {

        //创建连接池对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();


        //设置四大参数
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/author_book?serverTimezone=GMT&&rewriteBatchedStatements=true");
        comboPooledDataSource.setUser("liguang");
        comboPooledDataSource.setPassword("123456");

        //池配置
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setInitialPoolSize(20);
        comboPooledDataSource.setMinPoolSize(2);
        comboPooledDataSource.setMaxPoolSize(50);

        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
     * 配置文件的默认配置
     */
    @Test
    public void func2() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
     * 使用命名配置文件
     */
    @Test
    public void func3() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("oracle-config");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }



}
