package day19.Day19JdbcUtilsUpper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TxQueryRunner extends QueryRunner {

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /*
         * 1. 得到连接
         * 2. 执行父类方法，传递连接对象
         * 3. 释放连接
         * 4. 返回值
         */
        Connection con = Day19JdbcUtilsUpper.getConnection();
        int[] result = super.batch(con, sql, params);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, Object param, ResultSetHandler<T> rsh)
            throws SQLException {
        Connection con = Day19JdbcUtilsUpper.getConnection();
        T result = super.query(con, sql, param, rsh);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh)
            throws SQLException {
        Connection con = Day19JdbcUtilsUpper.getConnection();
        T result = super.query(con, sql, params, rsh);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        Connection con = Day19JdbcUtilsUpper.getConnection();
        T result = super.query(con, sql, rsh, params);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = Day19JdbcUtilsUpper.getConnection();
        T result = super.query(con, sql, rsh);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = Day19JdbcUtilsUpper.getConnection();
        int result = super.update(con, sql);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = Day19JdbcUtilsUpper.getConnection();
        int result = super.update(con, sql, param);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = Day19JdbcUtilsUpper.getConnection();
        int result = super.update(con, sql, params);
        Day19JdbcUtilsUpper.releaseConnection(con);
        return result;
    }
}
