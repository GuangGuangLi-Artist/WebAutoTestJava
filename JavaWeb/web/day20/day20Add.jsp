<%@ page import="day20.ListenerLearn.Day20Uesr" %><%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/5/22
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    day20.ListenerLearn.Day20Uesr user = new Day20Uesr();
    session.setAttribute("user",user);

%>
</body>
</html>
