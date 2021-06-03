<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/6/3
  Time: 22:15
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
            var xmlHttp = createXMLHttpRequest();
            xmlHttp.open("GET","<c:url value="/Day23ProvinceServlet"></c:url>",true);
            xmlHttp.send(null);
            xmlHttp.onreadystatechange = function () {
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    var text = xmlHttp.responseText;

                    var arr = text.split(",");

                    for (var i = 0; i < arr.length; i++) {
                        var op = document.createElement("option");
                        op.value = arr[i];
                        var textNode = document.createTextNode(arr[i]);
                        op.appendChild(textNode);

                        document.getElementById("p").appendChild(op);


                    };
                };
            };
            //第二件事


            var proSelect = document.getElementById("p");
            proSelect.onchange = function() {
                var xmlHttp = createXMLHttpRequest();
                xmlHttp.open("POST", "<c:url value='/Day23CityServlet'></c:url>", true);
                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xmlHttp.send("pname=" + proSelect.value);//把下拉列表中选择的值发送给服务器！
                xmlHttp.onreadystatechange = function() {
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                        /*
                        把select中的所有option移除（除了请选择）
                        */
                        var citySelect = document.getElementById("c");
                        // 获取其所有子元素
                        var optionEleList = citySelect.getElementsByTagName("option");
                        // 循环遍历每个option元素，然后在citySelect中移除
                        while(optionEleList.length > 1) {//子元素的个数如果大于1就循环，等于1就不循环了！
                            citySelect.removeChild(optionEleList[1]);//总是删除1下标，因为1删除了，2就变成1了！
                        }


                        var doc = xmlHttp.responseXML;
                        // 得到所有名为city的元素
                        var cityEleList = doc.getElementsByTagName("city");
                        // 循环遍历每个city元素
                        for(var i = 0; i < cityEleList.length; i++) {
                            var cityEle = cityEleList[i];//得到每个city元素
                            var cityName;
                            // 获取市名称
                            if(window.addEventListener) {//处理浏览器的差异
                                cityName = cityEle.textContent;//支持FireFox等浏览器
                            } else {
                                cityName = cityEle.text;//支持IE
                            }

                            // 使用市名称创建option元素，添加到<select name="city">中
                            var op = document.createElement("option");
                            op.value = cityName;
                            // 创建文本节点
                            var textNode = document.createTextNode(cityName);
                            op.appendChild(textNode);//把文本节点追加到op元素中

                            //把op添加到<select>元素中
                            citySelect.appendChild(op);
                        }
                    }
                };
            };

        };



    </script>
</head>
<body>
<h1>省市联动</h1>
<select name="province" id="p">
    <option>===请选择省===</option>
</select>
<br>
<select name="city" id="c">
    <option>===请选择市===</option>
</select>
</body>
</html>
