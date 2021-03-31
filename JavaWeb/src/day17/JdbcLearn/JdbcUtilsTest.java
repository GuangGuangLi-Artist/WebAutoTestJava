package day17.JdbcLearn;

import org.junit.Test;

import java.sql.SQLException;

public class JdbcUtilsTest {

    @Test
    public void fun1() throws SQLException {
        System.out.println(JdbcUtils.getConnection());
    }
}
