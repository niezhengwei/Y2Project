<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 2018/7/17
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
<script type="text/javascript">

    function updatePassword() {
        var flag=true;
        if(jQuery("[name=password]").val()=="")
        {
            alert("请输入密码！");
            return flag=false;
        }
        if(jQuery("[name=passwords]").val()=="")
        {
            alert("请确认你的密码！");
            return flag=false;
        }
        return flag;
    }
    function load(pageNum) {
        var uname=jQuery("[name=uname]").val();
        jQuery.ajax({
            url:"/FindAlllistUser",
            type:"post",
            data:{"name":uname,"pageNum":pageNum},
            success:function (data) {
                //清空数据
                jQuery("#list-content").html('');
                //追加数据
                jQuery.each(data.userType,function (i,dom) {
                    //一个dom就是一个用户对象
                    jQuery("#list-content").append("<tr><td>"+dom.id+"</td><td>"+dom.name+"</td><td>"+dom.userType.name+"</td><td>"+dom.status+"</td><td>"+dom.last_modify_time+"</td></tr>");
                });
                //渲染分页  总记录数  当前页码  每页数据量
                jQuery('#pagination').pagination(data.total, {
                    current_page : pageNum,
                    items_per_page : data.pageSize,
                    callback:load,
                    load_first_page : true,
                    prev_text : '上一页',
                    next_text : '下一页'
                });
            }
        });
    }
    jQuery(function ($) {
        jQuery("#update").hide();
         jQuery("#findAllUser").hide();
        jQuery("#updatePwd").click(function () {
            jQuery("#update").show();
            jQuery("#findAllUser").hide();
        });
      jQuery("#findAllListUser").click(function () {
            jQuery("#update").hide();
            jQuery("#findAllUser").show();
        });
        load(0);
    });
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>商务会员管理系统</h3>
用户名：${login.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户类型：管理员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/exit">退出</a><br>
<a id="updatePwd">修改密码</a><br>
<a id="findAllListUser">查看所有会员</a>



<div id="update" align="center">
    <h2>修改密码</h2>
    <form action="${pageContext.request.contextPath}/updateUser" method="post" onsubmit="return updatePassword()">
        <br/>
        <input type="hidden" id="ids" name="ids" value="${login.id}">
        请输入密码：<input type="text" name="password"/>
        <br/>
        确认密码：<input type="text" name="passwords"/>
        <br/>
        <br/>
        <input type="submit" value="确认修改"/>
    </form>
</div>



<div id="findAllUser" align="center">

    <h4>会员管理：&nbsp;&nbsp;&nbsp;&nbsp;
       用户名：<input type="text" name="uname">
        <input type="button" value="查询" onclick="javascript:load(1)"/>
    </h4>

    <table align="center" border="1px">
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>用户类别</th>
            <th>用户状态</th>
            <th>最后修改时间</th>
        </tr>
        <tbody id="list-content">

        </tbody>
    </table>
    <div  class="pagination" id="pagination"></div>
</div>


</body>
</html>
