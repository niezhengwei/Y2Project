<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">


</script>


<%--<script type="text/css">
    #questionList tr:odd{
        background-color: red;
    }

    #questionList tr:even{
        background-color: greenyellow;
    }



</script>--%>
<html>
<body>
<h2>在线问答</h2>
<h3><a href="${pageContext.request.contextPath}/questionJSp">我要提问</a></h3>
<table id="questionList" border="1px">
    <tr>
        <td>序号</td>
        <td>问题</td>
        <td>回答次数</td>
        <td>最后修改</td>
    </tr>
<c:forEach items="${questionList}" var="item">
    <tr id="aaa">
        <td>${item.id}</td>
        <td><a href="${pageContext.request.contextPath}/checkAnswer?qid=${item.id}">${item.title}</a></td>
        <td>${item.answerCount}</td>
        <td>${item.lastTime}</td>
    </tr>


</c:forEach>



</table>
</body>
</html>
