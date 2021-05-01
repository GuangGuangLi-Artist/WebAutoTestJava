package day17.JdbcLearn;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchDeal {

    @Test
    public void fun1() throws SQLException {

        Connection connection = JdbcUtils.getConnection();

        String sql = "insert into user values (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i <10000 ; i++) {
            preparedStatement.setInt(1,i+1);
            preparedStatement.setString(2,"stu_" + i);
            preparedStatement.setInt(3,28);
            preparedStatement.setString(4,i%2==0?"男":"女");

            preparedStatement.addBatch();

        }
        long start = System.currentTimeMillis();
        preparedStatement.executeBatch();
        long end = System.currentTimeMillis();

        System.out.println(end-start);


    }
}
