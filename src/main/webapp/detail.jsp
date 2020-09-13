<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <%@include file="head.jsp" %>
    <script>
        $(function () {
            var textareaObj = document.getElementById("textarea");
            var myHeight = textareaObj.scrollHeight;
            $("#textarea").outerHeight(myHeight+40)

            //实例化 ClipboardJS对象;
            var copyBtn = new ClipboardJS('.copyBtn');
            copyBtn.on("success", function (e) {
                // 复制成功
                $("#msg").html("复制成功");
            });
            copyBtn.on("error", function (e) {
                //复制失败；
                $("#msg").html("复制失败");
            });

            $("#deleteDate").html(getTime())
        })


    </script>
    <style>
        #textarea{
            font-size: 24px;
            background-color: white;
            color:#1b6d85;
        }
        #msg{
            color: #d43f3a;
        }
    </style>
</head>

<body>

<%@ include file="header.jsp" %>

<div class="container" id="success">
    <h1>${clipbrd.code}</h1>
    <h2><img src="data:image/png;base64,${clipbrd.QRcode}" }></h2>
    <div>当前已访问${clipbrd.times}次，如果没有再访问，过期时间为：<span id="deleteDate"></span></div>
    <button class="btn btn-success copyBtn" data-clipboard-target="#textarea" id="copyBtn">
        一键复制
    </button>
    <br/><br/>
    <span id="msg"></span>
    <br/>
    <textarea class="shadow-drop-center form-control" id="textarea" readonly="readonly">${clipbrd.context}
    </textarea>


</div>
<div class="text-center">
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>