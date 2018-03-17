<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/2/3
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("tr:even").css("background-color","#00FFFF");
        });

    </script>
</head>
<body>
<h3>班级成绩展示</h3>
<table border="2px"  cellspacing="0" cellpadding="0">
    <tr>
        <td>学生名字</td>
        <td>学生成绩</td>
        <td>考试时间</td>
        <td>班级名字</td>
    </tr>
    <c:forEach items="${lists}" var="item">
        <tr>
            <td>${item.stuname}</td>
            <td>${item.stuscore}</td>
            <td>${item.createtime}</td>
            <td>${item.classname}</td>
        </tr>
    </c:forEach>
</table>
<br>
<h3>统计成绩信息</h3>
<table border="2px" cellspacing="0" cellpadding="0">
<tr>
    <td>最高成绩</td>
    <td>最低成绩</td>
    <td>平均分</td>
</tr>
    <tr>
        <td>${maxs}</td>
        <td>${mins}</td>
        <td>${avgs}</td>
    </tr>

</table>
<br>
<input type="button" value="下载成绩"/>
</body>
</html>
