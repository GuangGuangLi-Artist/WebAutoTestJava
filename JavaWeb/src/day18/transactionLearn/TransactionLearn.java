package day18.transactionLearn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    修改指定用户的余额
 */
public class TransactionLearn {
    public void updateBalance(Connection connection, String name, double balance){
        String sql = "update account set balance=balance+? where name=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1,balance);
            preparedStatement.setString(2,name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
