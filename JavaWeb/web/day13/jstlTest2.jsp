<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/16
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="a" value="hello"></c:set>
<c:if test="${not empty a}">
    <c:out value="${a}"></c:out>
</c:if>


<c:set var="score" value="${param.score}"></c:set>
<c:choose>
    <c:when test="${score>100 || score < 0}">错误的分数：${score}</c:when>
    <c:when test="${score>=90}">A级 </c:when>
    <c:when test="${score>=80}">B级 </c:when>
    <c:when test="${score>=70}">C级 </c:when>
    <c:when test="${score>=60}">D级 </c:when>
    <c:otherwise>E级</c:otherwise>
</c:choose>
<br/>

<c:forEach var="i" begin="1" end="10">
    ${i}<br/>
</c:forEach>

<%
    String[] strs ={"one","two"};
    request.setAttribute("strs",strs);
%>
<c:forEach items="${strs}" var="str">
    ${str}<br/>
</c:forEach>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("一");
    list.add("二");
    list.add("三");

    pageContext.setAttribute("list",list);
%>
<c:forEach items="${list}" var="ele" varStatus="vs">
    ${ele}<br/>
    ${vs.count}<br>
    ${vs.index}<br>
    ${vs.first}<br>
    ${vs.last }<br>
</c:forEach>
</body>
</html>
