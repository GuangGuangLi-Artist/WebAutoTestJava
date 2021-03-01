<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/1
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
</head>
<body>
<%
    /*
    读取名为uname的Cookie,如果为空显示：""
    如果不为空显示:Cookie的值
     */
    String uname = "";
    Cookie[] cms = request.getCookies();//获取请求中所有的Cookie
    if(cms != null){//如果存在cookie
        for(Cookie c:cms){
            if("uname".equals(c.getName())){
                uname = c.getValue();
            }
        }
    }
%>

<%
    String message = "";
    String msg = (String)request.getAttribute("msg");//获取request域中的名为msg的属性
    if(msg != null){
        message = msg;
    }
%>

<font color="red"<b><%=message%></b></font>
<form action="/LoginServlet" method="post">
    用户名:<input type="text" name="username" value="<%=uname%>"/><br/>
    密  码:<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
