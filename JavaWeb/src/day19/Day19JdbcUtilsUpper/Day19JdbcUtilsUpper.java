package day19.Day19JdbcUtilsUpper;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Day19JdbcUtilsUpper {

    //配置文件的默认配置
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();


    //它是事务专用连接
    private static ThreadLocal<Connection> threadLocal1  = new ThreadLocal<Connection>();


    public static Connection getConnection() throws SQLException {
        Connection  connection= threadLocal1.get();
        //当connection不等于null,说明已经调用过beginTransaction（）；表示开启了事务
        if(connection != null) return connection;
        return dataSource.getConnection();
    }


    public static DataSource getDataSource(){
        return dataSource;
    }


    /**
     * 开启事务
     * 1：获取一个Connection，设置它的setAutoCommit(false)
     * 2：保证dao中使用的连接是我们刚刚创建的
     *
     * -----------------
     * 1. 创建一个Connection，设置为手动提交
     *  2. 把这个Connection给dao用！
     * 	3. 还要让commitTransaction或rollbackTransaction可以获取到！
     */
    public static void beginTransaction() throws SQLException {
        Connection connection = threadLocal1.get();

        if(connection != null) throw new SQLException("已经开启了事务，就不要重复开启了！");
        /*
        1:给con赋值
        2：给con设置为手动连接
         */
        connection = getConnection();//给con赋值，表示事务已经开始了
        connection.setAutoCommit(false);
        threadLocal1.set(connection);//把当前线程的连接保存起来


        //把它设置为null,表示事务已经结束了，下次再去调用getConnection()返回的就不是con了

    }

    /**
     * 提交事务
     * 1：获取一个Connection，然后调用commit方法
     */

    public static  void commitTransaction() throws SQLException {
        Connection connection = threadLocal1.get();

        if(connection == null) throw new SQLException("还没有开启事务，不能提交！");
        //直接使用commit
        connection.commit();
        connection.close();
        threadLocal1.remove();//从threadLocal1移除

    }

    /**
     * 回滚事务
     * 1：获取一个Connection，然后调用rollback方法
     */

    public static void rollbackTransaction() throws SQLException {
        Connection connection = threadLocal1.get();

        if(connection == null) throw new SQLException("还没有开启事务，不能回滚！");
        //直接使用rollback
        connection.rollback();
        connection.close();
        threadLocal1.remove();

    }


    public static void releaseConnection(Connection connection) throws SQLException {

        /*
         * 判断它是不是事务专用，如果是，就不关闭！
         * 如果不是事务专用，那么就要关闭！
         */
        Connection connection1 = threadLocal1.get();

        if(connection == null) connection.close();//如果connection==null,说明现在没有事务，那么connection一定不是事务专用的

        if(connection != null) connection.close();//说明有事务，那么需要判断参数连接是否与connection相等，若不等，说明参数连接不是事务专用连接
    }
}
