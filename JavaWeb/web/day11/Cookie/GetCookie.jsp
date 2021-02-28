<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/2/28
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取Cookie</title>
</head>
<body>
<h1>获取Cookie</h1>
<br>
<h1>使用request.getCookies()方法获取浏览器归还的Cookie</h1>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for (Cookie cookie:cookies){
            out.print(cookie.getName() + "=" + cookie.getValue() + "</br>");
        }
    }
%>
</body>
</html>
