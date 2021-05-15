package day18.JDbcUtilsLearn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilsDay18 {
    //配置文件的默认配置
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    public static DataSource getDataSource(){
        return dataSource;
    }
}
