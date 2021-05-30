<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/5/30
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>上传3</h1>
<h3>${msg}</h3>
<form action="<c:url value='/UploadLearn3'></c:url>" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"><br/>
    照  片：<input type="file" name="zhaopian"><br/>
    <input type="submit" value="上传">
</form>

</body>
</html>
