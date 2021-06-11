<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/12
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
<h1>上传</h1>
<form action="<c:url value="/Day28UploadServlet"></c:url>" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"><br/>
    简  历:<input type="file" name="resume"><br/>
    <input type="submit" value="提交">


</form>

</body>
</html>
