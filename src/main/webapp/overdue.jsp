<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="head.jsp"%>
    <script>
        $(function () {
            var code = getParameter("code");
            $("#code1").html(code);
            $("#code2").html(code);
        })
    </script>
</head>

<body>
<%@ include file="header.jsp"%>

<div class="container">
    <h2><span id="code2"></span>验证码已过期</h2>
    <p><a class="btn btn-lg btn-primary" href="create">新帖一块</a></p>
</div>

<div class="text-center">
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
