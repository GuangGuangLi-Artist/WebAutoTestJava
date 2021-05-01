package day18.transactionLearn;

import day17.JdbcLearn.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionTest {

    public void zhuanZhang(String from,String to,double money){
        //对事务的操作必须使用Connection对象
        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();

            //开启事务
            connection.setAutoCommit(false);

            TransactionLearn transactionLearn = new TransactionLearn();
            transactionLearn.updateBalance(connection,from,-money);

            if(true){
                throw new RuntimeException("就想错");
            }

            transactionLearn.updateBalance(connection,to,money);

            //提交事务
            connection.commit();
            connection.close();
        } catch (Exception e) {
           //回滚事务

            try {
                connection.rollback();
                connection.close();
            } catch (SQLException e1) {
                throw new RuntimeException(e);
            }

        }
    }


    @Test
    public void fun1(){
        zhuanZhang("zs","ls",100);
    }
}
