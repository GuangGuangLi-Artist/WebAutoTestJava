<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/6
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎管理员先生登录</h1>
<a href="<c:url value="/day21/day21index.jsp"></c:url>">游客入口</a><br>
<a href="<c:url value="/day21/admin/adminUser.jsp"></c:url>">管理员入口</a><br>
<a href="<c:url value="/day21/user/commonUser.jsp"></c:url>">会员入口</a><br>
</body>
</html>
