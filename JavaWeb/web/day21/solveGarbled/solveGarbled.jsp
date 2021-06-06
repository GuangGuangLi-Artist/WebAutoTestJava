<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/6
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value='/SolveGarbledServlet?username=张三'></c:url>">点击这里</a>
<form action="<c:url value='/SolveGarbledServlet'></c:url>" method="post">
    用户名:<input type="text" name="username" value="李四">
    <input type="submit" value="提交">


</form>

</body>
</html>
