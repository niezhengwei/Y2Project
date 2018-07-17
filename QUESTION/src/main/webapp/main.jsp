<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>小型进销存系统</title>
    <link rel="stylesheet" href="/css/public.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <script type="application/javascript" src="/js/jquery-1.8.3.min.js"/>
    <script type="application/javascript" src="/js/jquery.pagination.js"/>
    <script type="application/javascript">
        jQuery.noConflict();


        function addsale() {
            var flag=true;
            if(jQuery("[name=productId]").val()=="0")
            {
                alert("请选择商品！");
                return flag=false;
            }
            var manager=/^[1-9]\d*$/;
            if(jQuery("[name=quantitys]").val()==""||jQuery("[name=quantitys]").val()=="0")
            {
                alert("请输入数量！");
                return flag=false;
            }
            if(jQuery("[name=price]").val()=="")
            {
                alert("请输入单价！");
                return flag=false;
            }
           if(!manager.test(jQuery("[name=quantitys]").val()))
            {
                alert("商品数量必须为数字！");
                return flag=false;
            }
            return flag;
        }
        jQuery(function ($) {
            jQuery("#addsale").hide();
            jQuery("#salelist").hide();
            jQuery("#seachnumber").hide();
            jQuery("#addsales").click(function () {

                jQuery("#addsale").show();
                jQuery("#salelist").hide();
                jQuery("#seachnumber").hide();
            });
            jQuery("#salelists").click(function () {
                jQuery("#addsale").hide();
                jQuery("#salelist").show();
                jQuery("#seachnumber").hide();
            });
            jQuery("#seachnumbers").click(function () {
                jQuery("#seachnumber").show();
                jQuery("#addsale").hide();
                jQuery("#salelist").hide();

            });
            load(0);

        });
        function load(pageNum) {
            var order=jQuery("[name=order]").val();
            jQuery.ajax({
                url:"/sale/salelist",
                type:"post",
                data:{"order":order,"pageNum":pageNum},
                success:function (data) {
                    //清空数据
                    jQuery("#list-content").html('');
                    //追加数据
                    jQuery.each(data.list,function (i,dom) {
                        //一个dom就是一个用户对象
                        jQuery("#list-content").append("<tr><td>"+dom.id+"</td><td>"+dom.product.productName+"</td><td>"+dom.price+"</td><td>"+dom.quantitys+"</td><td>"+dom.totalPrice+"</td><td>"+dom.datetime+"</td><td>"+dom.users.realName+"</td></tr>");
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

    </script>
</head>
<body>
<div align="center">
    <div>
        欢迎您：<span th:text="${usermodel.userName}"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
            href="javascript:logout()">退出登陆</a>
    </div>
    <br/>
    <br/>
    <div>
        <a id="addsales">销售</a>
        <br/>
        <br/>
        <a id="salelists">销售信息查询</a>
        <br/>
        <br/>
        <a id="seachnumbers">查看库存</a>
    </div>
    <div style="border: groove;border-color: blue;width: 800px;height: 700px;" align="right">
        <div id="first" align="center">
            <h2>欢迎光临小型进销存系统</h2>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <div id="addsale" align="center">
            <h2>添加销售</h2>
            <form action="/sale/insertSale" method="post" onsubmit="return addsale()">
                商品名称：
                <select name="productId">
                    <option value="0">请选择商品</option>
                    <span th:each="pro:${productList}">
                    <option th:value="${pro.id}"><span th:text="${pro.productName}"></span></option>
                    </span>
                </select>
                <br/>
                销售单价：<input type="text" name="price"/>
                <br/>
                销售数量：<input type="text" name="quantitys"/>
                <br/>
                <br/>
                <input type="submit" value="保存"/>
            </form>
        </div>

        <div id="salelist" align="center">

            <h4>销售信息查询：&nbsp;&nbsp;&nbsp;&nbsp;排序方式：
                <select name="order">
                    <option value="销售日期">销售日期</option>
                    <option value="单笔总价">单笔总价</option>
                </select>
                <input type="button" value="查询" onclick="javascript:load(1)"/>
            </h4>

            <table align="center" border="1px">
                <tr>
                    <th>ID</th>
                    <th>商品</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>总价</th>
                    <th>销售日期</th>
                    <th>销售员</th>
                </tr>
                <tbody id="list-content">

                </tbody>

            </table>
            <div  class="pagination" id="pagination"></div>
        </div>

        <div id="seachnumber" align="center">
            <h4>查看库存&nbsp;&nbsp;&nbsp;商品名称：

                <select name="numberid">
                    <option value="0">请选择商品</option>
                    <span th:each="pro:${productList}">
                        <option th:value="${pro.id}"><span th:text="${pro.productName}"></span></option>
                    </span>
                </select>

                <input type="button" value="查询" onclick="seachnumber()"/>
            </h4>
            <h3>该商品的库存数量为：<span name="number"></span></h3>
        </div>
    </div>
</div>


</body>
</html>