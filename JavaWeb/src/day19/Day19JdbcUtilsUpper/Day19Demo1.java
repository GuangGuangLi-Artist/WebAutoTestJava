package day19.Day19JdbcUtilsUpper;

import org.junit.Test;

import java.sql.SQLException;

public class Day19Demo1 {
    private Day19AccountDao day19AccountDao = new Day19AccountDao();

    @Test
    public void day19ServiceMethod() throws SQLException {
        try {
            Day19JdbcUtilsUpper.beginTransaction();
            day19AccountDao.day19Update("zs",-1000);
            day19AccountDao.day19Update("ls",1000);
            Day19JdbcUtilsUpper.commitTransaction();


        } catch (Exception e) {
            try {
                Day19JdbcUtilsUpper.rollbackTransaction();
            } catch (SQLException e1) {

            }
            throw e;

        }
    }


}
