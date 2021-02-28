<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/2/28
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>保存Cookie</title>
</head>
<body>
<p>保存Cookie</p>
<br>
<p>使用repsonse.addCookie()方法向浏览器保存Cookie</p>
<%
  Cookie c1 = new Cookie("aaa","AAA");
  //设置过期时间
  c1.setMaxAge(60);


  response.addCookie(c1);
  Cookie c2 = new Cookie("bbb","BBB");
  response.addCookie(c2);
%>
</body>
</html>
