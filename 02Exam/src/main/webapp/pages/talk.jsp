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
    <title>查看成绩</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Servlet/TalkServlet" method="post">
    请输入你查看的班级名称：
    <input type="text" name="classname"/>
    <input type="submit" value="查看"/>
</form>
</body>
</html>
