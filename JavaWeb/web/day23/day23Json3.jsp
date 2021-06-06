<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/6
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<c:url value="/day23/ajaxutils.js"></c:url>"></script>
    <script type="text/javascript">

        window.onload = function () {
            var btn = document.getElementById("btn");
            btn.onclick = function () {
                ajax(
                    {
                        url:"<c:url value="/Day23JsonServlet"></c:url>",
                        type:"json",
                        callback:function (data) {
                            document.getElementById("h2").innerHTML = data.name + "," + data.age + "," + data.sex;
                        }
                }
                )
            }
        }
    </script>
</head>
<body>
<h1>AjaxUtils学习</h1>
<button id="btn">点击这里</button>
<h2 id="h2"></h2>
</body>
</html>
