<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/6
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function createXMLHttpRequest(){
            try{
                return new XMLHttpRequest();//大多数浏览器
            }catch (e) {
                try {
                    return ActiveXObject("Xsxml2.XMLHTTP");//IE6.0
                }catch (e) {
                    try {
                        return ActiveXObject("Microsoft.XMLHTTP");//IE5.5及更早版本
                    }catch (e) {
                        alert("您的浏览器不支持");
                        throw e;
                    }
                }
            }
        }

        window.onload = function () {
            var btn = document.getElementById("btn");
            btn.onclick = function () {
                var xmlHttp = createXMLHttpRequest();
                xmlHttp.open("GET","<c:url value="/Day23JsonServlet"></c:url>",true);
                xmlHttp.send(null);

                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        var text = xmlHttp.responseText;

                        var  person = eval("("  + text+ ")");
                        var s = person.name + "," +  person.age + "," + person.sex;
                        document.getElementById("h2").innerHTML = s;
                    }
                }

            }
        }
    </script>
</head>
<body>
<h1>Json版的学习</h1>
<button id="btn">点击这里</button>
<h2 id="h2"></h2>
</body>
</html>
