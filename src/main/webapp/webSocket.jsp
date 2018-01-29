<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/8/21
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSocket</title>
</head>
<body>
<div>
    <input type="button" value="send" onclick="start()"/>
</div>
<div id="msg"></div>
<script>
    var url = "ws://localhost:8888/webSocket";
    var webSocket = new WebSocket(url);
    webSocket.onerror = function (event) {
        alert(event.data);
        onError(event);
    };
    webSocket.onopen = function (event) {
        onOpen(event);
    };
    webSocket.onmessage = function (event) {
        onMessage(event);
    };

    function onMessage(event) {
        document.getElementById("msg").innerHTML +="<br/>"+event.data;
    }

    function onOpen(event) {
        document.getElementById("msg").innerHTML='Connection established';
    }

    function onError(event) {
        alert(event.data);

    }

    function start() {
        webSocket.send("hello");
        return false;
    }
</script>
</body>
</html>
