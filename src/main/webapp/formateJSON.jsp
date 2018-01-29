<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/8/19
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>原生js格式化json的方法</title>
</head>
<body>
<!--格式化后的json写入的位置-->
<input type="text" id="json" value="${json}"/>
<div id="writePlace"></div>
<script>

    //引用示例部分
    //(1)创建json格式或者从后台拿到对应的json格式
    <%--var originalJson = decodeURIComponent(${json});--%>
    var originalJson = "${json}";
    var s = decodeURIComponent(originalJson);
    alert(s);
    //(2)调用formatJson函数,将json格式进行格式化
//    var resultJson = formatJson(originalJson);
    //(3)将格式化好后的json写入页面中
//    document.getElementById("writePlace").innerHTML = '<pre>' +resultJson + '<pre/>';

    //格式化代码函数,已经用原生方式写好了不需要改动,直接引用就好
    var formatJson = function (json, options) {
        var reg = null,
            formatted = '',
            pad = 0,
            PADDING = '    ';
        options = options || {};
        options.newlineAfterColonIfBeforeBraceOrBracket = (options.newlineAfterColonIfBeforeBraceOrBracket === true) ? true : false;
        options.spaceAfterColon = (options.spaceAfterColon === false) ? false : true;
        if (typeof json !== 'string') {
            json = JSON.stringify(json);
        } else {
            json = JSON.parse(json);
            json = JSON.stringify(json);
        }
        reg = /([\{\}])/g;
        json = json.replace(reg, '\r\n$1\r\n');
        reg = /([\[\]])/g;
        json = json.replace(reg, '\r\n$1\r\n');
        reg = /(\,)/g;
        json = json.replace(reg, '$1\r\n');
        reg = /(\r\n\r\n)/g;
        json = json.replace(reg, '\r\n');
        reg = /\r\n\,/g;
        json = json.replace(reg, ',');
        if (!options.newlineAfterColonIfBeforeBraceOrBracket) {
            reg = /\:\r\n\{/g;
            json = json.replace(reg, ':{');
            reg = /\:\r\n\[/g;
            json = json.replace(reg, ':[');
        }
        if (options.spaceAfterColon) {
            reg = /\:/g;
            json = json.replace(reg, ':');
        }
        (json.split('\r\n')).forEach(function (node, index) {
                var i = 0,
                    indent = 0,
                    padding = '';

                if (node.match(/\{$/) || node.match(/\[$/)) {
                    indent = 1;
                } else if (node.match(/\}/) || node.match(/\]/)) {
                    if (pad !== 0) {
                        pad -= 1;
                    }
                } else {
                    indent = 0;
                }

                for (i = 0; i < pad; i++) {
                    padding += PADDING;
                }

                formatted += padding + node + '\r\n';
                pad += indent;
            }
        );
        return formatted;
    };
</script>
</body>
</html>
