package day19.Day19JdbcUtilsUpper;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class Day19AccountDao {

    public static void day19Update(String name,double money) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "update account set balance=balance+? where name=?";
        Object[] params = {money,name};


        //我们需要自己来提供连接，保证多次调用的是同一个连接
        queryRunner.update(sql,params);


    }
}
