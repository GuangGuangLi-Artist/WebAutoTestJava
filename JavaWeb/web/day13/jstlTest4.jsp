<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/18
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="it" uri="http://www.guangguanghome.cn/el/customize" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<it:CustomizeJspTag5 test="${empty param.xxx}">
<h1>
    <it:CustomizeJspTag4/>
</h1>
</it:CustomizeJspTag5>
<h1><it:CustomizeJspTag/></h1>
<hr>
<h1><it:CustomizeJspTag2/></h1>
<hr>
<%
    request.setAttribute("xxx","zhangsan");
%>
<h3>
    <it:CustomizeJspTag3>${xxx}</it:CustomizeJspTag3>
</h3>
<hr>
<h3>
    <it:CustomizeJspTag3>我是张三的大哥</it:CustomizeJspTag3>
</h3>
</body>
</html>