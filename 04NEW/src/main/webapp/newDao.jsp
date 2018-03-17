<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/3/1
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
            function show(pageIndex) {
                location.href="/servlet/newDaoServlet?pageIndex="+(pageIndex-1);
            }
            function shows(pageIndex) {
                location.href="/servlet/newDaoServlet?pageIndex="+(pageIndex+1);
            }
            $(function () {
                $("tr:even").css("background-color","pink");
            });
            $(function () {
                $("tr:odd").css("background-color","red");
            });
    </script>
    <title>新闻展示</title>
</head>
<body>
<h3>欢迎来到新闻网</h3>
<table border="1px" cellpadding="0px" cellspacing="0px">
    <tr>
        <td>编号</td>
        <td>标题</td>
        <td>访问量</td>
        <td>评论次数</td>
    </tr>
    <c:forEach items="${list}" var="item">
    <tr>
        <td>${item.newsid}</td>
        <td><a href="${pageContext.request.contextPath}/servlet/newListServlet?action=click&id=${item.newsid}">${item.newstitle}</a></td>
        <td>${item.clickcount}</td>
        <td>${item.talks.size()}</td>
    </tr>
    </c:forEach>
</table>
当前页码：<input type="text" value="${page.pageIndex}" style="width: 20px"/>
<c:if test="${page.pageIndex>1}">
<button onclick="show(${page.pageIndex})">上一页</button>
</c:if>
<c:if test="${page.pageIndex<page.totalPage}">
    <button onclick="shows(${page.pageIndex})">下一页</button>
</c:if>
</body>
</html>
