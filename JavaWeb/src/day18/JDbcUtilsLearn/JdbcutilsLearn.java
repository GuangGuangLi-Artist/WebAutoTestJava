package day18.JDbcUtilsLearn;

import day17.JdbcLearn.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcutilsLearn {


    @Test
    public void fun1() throws SQLException {

        QueryRunner qr = new QueryRunner(JdbcUtilsDay18.getDataSource());
        String sql = "insert into t_stu values(?,?,?,?)";
        Object[] params = {1003,"zhangsan",88,"female"};
        qr.update(sql,params);
    }


    @Test
    public void fun2() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsDay18.getDataSource());


        String sql = "select * from t_stu where sid=? ";
        Object[] params = {1002};
        //执行query方法，需要给出结果集处理器，即ResultHandler的实现类对象，我们给出的是BeanHandler,它实现了ResultHandler，
        //它需要一个类型，然后它会把rs中的数据封装到指定的javabean中，然后返回javabean
        StuDay18 stuDay18 = qr.query(sql,new BeanHandler<StuDay18>(StuDay18.class),params);
        System.out.println(stuDay18);

    }

    /**
     * BeanListHandler的应用，它是多行处理器,每行对象一个Stu对象！
     */
    @Test
    public void fun3() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsDay18.getDataSource());
        String sql = "select * from t_stu";
        List<StuDay18> stuList = qr.query(sql,new BeanListHandler<StuDay18>(StuDay18.class));
        System.out.println(stuList);

    }

    /**
     * MapHandler的应用，它是单行处理器，把一行转换成一个Map对象
     */

    @Test
    public void fun4() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsDay18.getDataSource());
        String sql = "select * from t_stu where sid=?";
        Object[] params = {1003};
        Map stuMap = qr.query(sql,new MapHandler(),params);
        System.out.println(stuMap);
    }


    /**
     * MapListHandler，它是多行处理器，把每行都转换成一个Map，即List<Map>
     */

    @Test
    public void fun5() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsDay18.getDataSource());
        String sql = "select * from t_stu";
        List<Map<String,Object>> mapList = qr.query(sql,new MapListHandler());
        System.out.println(mapList);
    }


    /**
     * ScalarHandler，它是单行单列时使用，最为合适！
     */
    @Test
    public void fun6() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsDay18.getDataSource());
        String sql = "select count(*) from t_stu";
        Number cnt = (Number) qr.query(sql,new ScalarHandler<>());
        long c = cnt.longValue();
        System.out.println(c);
    }


}
