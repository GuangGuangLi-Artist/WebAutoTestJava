<%--
  Created by IntelliJ IDEA.
  User: 94010
  Date: 2021/3/9
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="day12.ELLearn.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Address address = new Address();
    address.setCity("西安");
    address.setStreet("朱雀大街");

    Employee employee = new Employee();
    employee.setName("烦啦");
    employee.setSalary("11000");
    employee.setAddress(address);

    request.setAttribute("employee",employee);
%>
<h4>使用el获取request域中的emp</h4>
${requestScope.employee.address.street}
${employee.hehe}
</body>
</html>
