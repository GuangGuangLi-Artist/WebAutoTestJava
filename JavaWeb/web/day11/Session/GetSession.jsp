<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/2/28
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>getSession</h1>
<%
    String s = (String) session.getAttribute("name");
    out.print(s);
%>
</body>
</html>
