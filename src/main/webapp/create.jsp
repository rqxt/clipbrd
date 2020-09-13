<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html >
<head>
    <%@include file="head.jsp"%>
    <script>
        $(function () {
            $("#form").submit(function () {
                var context = $("#context").val();
                // 文本框内容为空
                if (context.trim().length < 1 || context == undefined) {
                    $("#errorMsg").html("内容不能为空");
                    return false;
                }
                // 如果内容不为空，则放行
            })
        })
    </script>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>贴一块</h2>
    <form method="post" action="createOne" id="form">
        <sapn class="bold">请输入内容</sapn>
        <br/>
        <textarea id="context" name="context" class="form-control" rows="12"></textarea><br/>
        <span id="errorMsg"></span><br/>
        <input type="submit" value="贴出去" class="btn btn-primary"/><br/>
    </form>
</div>
<div class="text-center">
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>