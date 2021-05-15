package day18.JNDILearn;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JNDILearnServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建JNDI的上下文对象
        try {
            Context context = new InitialContext();
            //查询入口
            Context envContext = (Context)context.lookup("java:comp/env");
            //再次二次查询，找到我们的资源
            DataSource dataSource = (DataSource)envContext.lookup("jdbc/dataSource");

            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
