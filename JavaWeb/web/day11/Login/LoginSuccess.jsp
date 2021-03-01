<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/1
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>success_1</h1>
<%
    String username = (String)session.getAttribute("username");
    if(username==""){
        //向request域中保存错误信息，转发到login.jsp
        request.setAttribute("msg","您还没有登录，不要冒充领导");
        request.getRequestDispatcher("/day11/Login/login.jsp").forward(request,response);
        return;
    }
%>
欢迎欢迎，热烈欢迎，欢迎<%=username %>领导指导工作！
</body>
</html>
