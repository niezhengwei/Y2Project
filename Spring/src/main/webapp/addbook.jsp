<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/3/17
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/IBookServlet" method="post">
    图书名字：<input type="text" name="bookName"><br>
    图书作者：<input type="text" name="bookAuther"><br>
    图书价格：<input type="text" name="bookPrice"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
