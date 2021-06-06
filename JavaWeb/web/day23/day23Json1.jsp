<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/6
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function () {
            var str = "{\"name\":\"张三\",\"age\":\"18\",\"sex\":\"male\"}";
            var person = eval("(" + str + ")");
            alert(person.name + "," + person.age + "," + person.sex);
        }
    </script>
</head>
<body>
<h1>json的应用</h1>
</body>
</html>
