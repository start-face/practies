<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/9/17
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转的JSP</title>
</head>
<body>
<h1>This is To.Jsp Page</h1>
用户1：<%= request.getParameter("zhangsan")%><br/><br/>
用户2：<%= request.getParameter("lisi")%>
</body>
</html>
