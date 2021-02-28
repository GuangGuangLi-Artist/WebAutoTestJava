<%-- Created by IntelliJ IDEA. --%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>>">
    <title></title>
</head>
<body>
This is my jsp page <br/>
<%
    int a = 10;
%>

<%
    out.print(a);
%>
<br/>
<%=a%>
<%!
    int  a = 10;
    public void fun1(){
        System.out.println(a);
    }
%>
<%
    out.print(this.a++);
    fun1();
%>
</body>
</html>