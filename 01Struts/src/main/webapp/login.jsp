<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/6/11
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action="/user/login" method="post">
    用户名：<input name="user.userName"/><br>
    密码：<input name="user.password"/><br>
    <input type="submit" value="提交">
</form>--%>
<%--动态方法调用--%>
<%--
<a href="user/users!add">新增</a>
<a href="user/users!delete">删除</a>
<a href="user/users!update">修改</a>
<a href="user/users!find">查询</a>
--%>


<%--通配符使用--%>
<%--<a href="user/ActionInfo_add">新增</a>
<a href="user/ActionInfo_delete">删除</a>
<a href="user/ActionInfo_update">修改</a>
<a href="user/ActionInfo_find">查询</a>--%>

<%--namespace匹配规则--%>
<a href="user/users/clickData">点击获取数据</a>
<a href="user/users/userss/clickData">点击获取数据1</a>

<a href="helloaction1">添加</a>
<a href="helloaction2">删除</a>
<a href="helloaction3">修改</a>


</body>

</html>
