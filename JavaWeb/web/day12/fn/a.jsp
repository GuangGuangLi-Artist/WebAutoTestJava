<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/12
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language=  "java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL提供的EL函数库</h1>

<%
    String [] strings = {"a","b","c"};
    List list = new ArrayList();
    list.add('a');
    pageContext.setAttribute("arr",strings);
    pageContext.setAttribute("list",list);
%>

${fn:length(arr)};<br/>
${fn:toLowerCase("HeLLO")};<br/>
</body>
</html>
