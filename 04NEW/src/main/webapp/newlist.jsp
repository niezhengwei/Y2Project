<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/3/1
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>评论</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("tr:even").css("background-color","pink");
        });
    </script>
</head>
<body>

<h3>新闻标题:${all.newstitle}</h3>
<p style="color: red">新闻内容：${all.newscontent}</p>
<table border="1px" cellspacing="0px" cellpadding="0px">
<tr>
    <td>评论时间</td>
    <td>评论内容</td>
</tr>
    <c:forEach items="${all.talks}" var="item">
        <tr>
            <td>${item.talktime}</td>
            <td>${item.content}</td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="${pageContext.request.contextPath}/servlet/newListServlet?action=content" method="post">
    <input type="hidden" name="id" value="${all.newsid}"/>
    添加评论：
    <br>
    <textarea style="width: 200px;height: 200px" name="tname"></textarea>
        <input type="submit" value="提交"/>

</form>
</body>
</html>
