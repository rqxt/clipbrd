<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp"%>
    <script>
        $(function(){
            $("#form").submit(function(){
                var code = $("#code").val();
                // 文本框内容为空
                if(code.trim().length < 1 || code == undefined){
                    $("#errorMsg").html("搜索码不能为空")
                    return false;
                }else if(code.trim().length != 4){
                    $("#errorMsg").html("访问码应是4位数")
                    return false;
                }
                // 如果内容不为空，则放行

            })
        })
    </script>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="container">
    <h2>找一块</h2>
    <form method="get" action="findOne" id="form">
        输入访问码：
        <input id="code" type="text" name="code" class="form-control"/><br/>
        <span id="errorMsg"></span><br/>
        <input type="submit" value="找一块" class="btn btn-primary"/><br/>
    </form>
</div>
</body>

<div class="text-center">
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    <%@ include file="footer.jsp" %>
</div>
</html>
