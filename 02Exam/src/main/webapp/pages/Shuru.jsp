<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/2/1
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>录入答案</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Servlet/ImportServlet" method="post">
    请输入答案：<br>
    <textarea rows="10" cols="10" style="width: 300px;height: 300px" name="answer">
</textarea><br>
    请输入班级：<input type="text" name="classname"/><br>
    <input type="submit" value="录入答案"/>
</form>
</body>
</html>
