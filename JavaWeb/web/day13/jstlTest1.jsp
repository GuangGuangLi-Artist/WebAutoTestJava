<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/14
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("code1","<script>alert('hello')</script>");
%>
<c:set var="code" value="<script>alert('hello')</script>" scope="session"></c:set>
${code}
<c:out value="${code}" escapeXml="false"></c:out>

<c:remove var="code1" scope="session"></c:remove>

<c:url value="/index.jsp">
    <c:param name="username" value="subiao"></c:param>
</c:url>
<br/>
<a href="<c:url value='/index.jsp'></c:url> ">点击这里回到主页</a>
<br/>

</body>
</html>