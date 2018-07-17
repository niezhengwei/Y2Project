<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">


</script>


<html>
<body>
<table>

    <tr>
        <td>问题:</td>
        <td>问题描述:</td>
    </tr>

    <tr>
        <td>${answers.title}</td>
        <td>${answers.detailDesc}</td>
    </tr>

    <tr>
        <td>网友回答</td>
    </tr>

   <c:forEach items="${answers.lists}" var="item">
       <tr>
           <td>${item.ansContent}</td>
       </tr>
   </c:forEach>

</table>

<form action="${pageContext.request.contextPath}/addAnswer" method="post">
    我来回答：<br>
    <textarea name="ansContent">

    </textarea><br>
    <input type="hidden" name="ids" value="${answers.id}">
    <input type="submit" value="提交答案"><a href="${pageContext.request.contextPath}/main">返回首页</a>
</form>
</body>
</html>
