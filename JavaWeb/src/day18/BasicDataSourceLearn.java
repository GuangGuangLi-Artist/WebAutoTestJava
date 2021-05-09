package day18;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

public class BasicDataSourceLearn {


    @Test
    public void fun1() throws SQLException {


        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/author_book?serverTimezone=GMT&&rewriteBatchedStatements=true");
        dataSource.setUsername("liguang");
        dataSource.setPassword("123456");

        dataSource.setMaxTotal(30);
        dataSource.setMaxIdle(3);
        dataSource.setMaxWaitMillis(1000);

        Connection connection = dataSource.getConnection();


        Connection connection1 = new MyConnection(connection);

        System.out.println(connection1.getClass().getName());


        connection1.close();

    }



}

class MyInputStream extends InputStream{
    private InputStream in;
    private int key;

    public MyInputStream(InputStream in, int key){
        this.in = in;
        this.key = key;
    }

    @Override
    public int read() throws IOException{
        return this.in.read() - key;
    }
}
