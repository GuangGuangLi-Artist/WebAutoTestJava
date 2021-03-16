<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/16
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Date date= new Date();
    pageContext.setAttribute("date",date);
%>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
<hr>
<%
    request.setAttribute("num1",3.1415926);
%>
<fmt:formatNumber value="${num1}" pattern="0.000"></fmt:formatNumber>
<fmt:formatNumber value="${num1}" pattern="#.###"></fmt:formatNumber>
</body>
</html>
