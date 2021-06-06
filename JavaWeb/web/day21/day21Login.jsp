<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/6
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="<c:url value="/Day21LoginServlet"></c:url>" method="post">
    用户名:<input type="text" name="username">
           <input type="submit" value="登录">
</form>
</body>
</html>
