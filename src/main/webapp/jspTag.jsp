<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/9/17
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JsP的标签页</title>
</head>
<body>
<jsp:forward page="toJsp.jsp">
    <jsp:param name="zhangsan" value="123"/>
    <jsp:param name="lisi" value="456"/>
</jsp:forward>
</body>
</html>
