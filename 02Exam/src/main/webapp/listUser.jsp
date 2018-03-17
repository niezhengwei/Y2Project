<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/2/6
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript">
    $(function () {

        $.messager.alert('显示成功','确认关闭提示框吗?','info');

        $('#dd').datebox( {
            currentText : '今天',
            closeText : '关闭',
            disabled : false,
            required : true,
            missingMessage : '必填',
            formatter : formatDate

        });
    });
    function  disable() {
        $("#dd").datebox("disable");
    }
    function enable() {
        $("#dd").datebox("enable");
    }

    function formatDate(v) {
        if (v instanceof Date) {
            var y = v.getFullYear();
            var m = v.getMonth() + 1;
            var d = v.getDate();
            var h = v.getHours();
            var i = v.getMinutes();
            var s = v.getSeconds();
            var ms = v.getMilliseconds();
            if (ms > 0)
                return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s
                    + '.' + ms;
            if (h > 0 || i > 0 || s > 0)
                return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s;
            return y + '-' + m + '-' + d;
        }
        return '';
    }


</script>
<html>
<head>
    <title>我的easyui页面</title>
</head>
<body>
<table class="easyui-datagrid" title="用户列表" style="width:700px;height:250px"
       data-options="singleSelect:true,collapsible:true,url:'${pageContext.request.contextPath}/Servlet/UserNewServlet',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'uid',width:80">学生编号</th>
        <th data-options="field:'username',width:100">学生名字</th>
        <th data-options="field:'upwd',width:80,align:'right'">学生密码</th>
        <th data-options="field:'classname',width:80,align:'right'">班级名字</th>
    </tr>
    </thead>
</table>


<h1>DateBox</h1>
<div style="margin-bottom: 10px;"><a href="#" onclick=
        disable();
>disable</a>
    <a href="#" onclick=
            enable();
    >enable</a></div>
<input id="dd"></input>

</body>
</html>
