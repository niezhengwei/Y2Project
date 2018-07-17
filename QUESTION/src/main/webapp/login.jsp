<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/7/17
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>会员信息管理系统</h3>
<form action="${pageContext.request.contextPath}/loginuser" method="post">
用户名：
    <input type="text" name="name"><br>
    登陆：
    <input type="text" name="password"><br>
    <input type="submit" value="提交">

</form>

</body>
</html>
