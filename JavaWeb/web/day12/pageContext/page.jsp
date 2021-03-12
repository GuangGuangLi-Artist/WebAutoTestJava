<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/11
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
${pageContext.request.contextPath}
<hr/>

<a href="${pageContext.request.contextPath}/day12/ELLearn/ELtext.jsp">点击这里</a>
<hr/>
<form action="${pageContext.request.contextPath}/day12/params/params.jsp" method="post">
    <input type="submit" value="提交">
</form>
<hr>

${pageContext.session.id}

</body>
</html>
