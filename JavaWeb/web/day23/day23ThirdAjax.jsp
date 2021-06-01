<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/1
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
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
                    };
                };
            };
        };

        window.onload = function() {
            // 获取文本框，给它的失去焦点事件注册监听
            var userEle = document.getElementById("usernameEle");
            userEle.onblur = function() {
                //1.得到异步对象
                var xmlHttp = createXMLHttpRequest();
                //2.打开连接
                xmlHttp.open("POST", "<c:url value='/Day23ThirdServelt'></c:url>", true);
                //3.设置请求头：Content-Type
                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                //4.发送请求，给出请求体
                xmlHttp.send("username=" + userEle.value);

                //5.给xmlHttp的onreadystatechange事件注册监听
                xmlHttp.onreadystatechange = function() {
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {//双重判断
                        //获取服务器的响应，判断是否为1
                        // 是：获取span，添加内容：“用户名已被注册”
                        var text = xmlHttp.responseText;
                        var span = document.getElementById("errSpan");
                        if(text == "1") {
                            //得到span元素
                            span.innerHTML = "用户名已被注册！";
                        } else {
                            span.innerHTML = "";
                        }
                    }
                };
            };
        };


    </script>
</head>
<body>
<h1>演示用户名是否被注册</h1>
<form action="<c:url value='/Day23ThirdServelt'></c:url>" method="post">
    用户名：<input type="text" name="username" id="usernameEle"><span id="errSpan"></span><br>
    密  码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
