<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/4/12
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>注册</h1>
<p style="color: red; font-weight: 900 ">${msg}</p>
<%--${pageContext.request.contextPath}/RegisterServlet17--%>
<form action="<c:url value='/RegisterServlet17'></c:url> " method="post">
    用户名:<input type="text" name="username" value="${user.username}">
    <span style="color: red; font-size: 10pt;font-weight: 900;">${errors.username}</span><br>
    密  码:<input type="password" name="password" value="${user.password}">
    <span style="color: red; font-size: 10pt;font-weight: 900;">${errors.password}</span><br>
    确认密码:<input type="password" name="repassword" value="${form.repassword}">
    <span style="color: red; font-size: 10pt;font-weight: 900;">${errors.repassword}</span><br>
    年  龄:<input type="text" name="age" value="${form.age}">
    <span style="color: red; font-size: 10pt; font-weight: 900">${errors.age}</span></br>
    性  别:<input type="text" name="gender" value="${form.gender}">
    <span style="color: red; font-size: 10pt; font-weight: 900">${errors.gender}</span></br>
    <input type="submit" value="注册">
</form>
</body>
</html>