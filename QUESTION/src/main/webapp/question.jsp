<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">


</script>


<html>
<body>
<h2>我要提问</h2>
<h3><a href="${pageContext.request.contextPath}/main">返回首页</a></h3>
<form method="post" action="${pageContext.request.contextPath}/addquestion">
    问&nbsp;&nbsp;&nbsp;题：
    <input type="text" name="title"><br>
    问题描述：
    <textarea></textarea><br>

    <input type="submit" value="保存问题">



</form>



</table>
</body>
</html>
