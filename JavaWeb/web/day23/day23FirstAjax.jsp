<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/5/31
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


        window.onload = function () { //文档加载完毕后执行
            var btn = document.getElementById("btn");
            btn.onclick = function () {//给按钮的点击时间注册监听
                /*
                ajax四步操作，得到服务器额响应
                把响应结果显示到h1元素中
                 */
                //得到异步对象
                var xmlHttp = createXMLHttpRequest();

                //打开与服务器的连接
                //指定请求方式，指定请求的url,指定是否为异步请求
                xmlHttp.open("GET","<c:url value="/Day23FirstServelt"></c:url>",true);

                //发送请求
                xmlHttp.send(null);//GET请求没有请求体，但也要给出null,不然fireFox可能不能发送

                //给异步对象的onreadystatechange注册监听器
                xmlHttp.onreadystatechange = function () {//当xmlhttp的状态发生变化时执行
                    //双重判断。xmlHttp的状态为4(服务器响应结束),以及服务器响应的额状态码为200（响应成功）
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        //获取服务器的响应内容
                        var text = xmlHttp.responseText;

                        var h1 = document.getElementById("h1");
                        h1.innerHTML = text;

                    };
                };
            };
        };
    </script>
</head>
<body>
<button id="btn">点击这里</button>
<h1 id="h1"></h1>
</body>
</html>
