<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/9
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("xxx","request_xxx");
    pageContext.setAttribute("xxx","pageContext_xxx");
    session.setAttribute("xxx","session_xxx");
    application.setAttribute("xxx","application_xxx");
%>
${xxx}<br/>
${requestScope.xxx}<br>
${pageScope.xxx}<br>
${sessionScope.xxx}<br>
${applicationScope.xxx}<br>
</body>
</html>
