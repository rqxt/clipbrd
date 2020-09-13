<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <div class="wrap">
        <%@ include file="header.jsp"%>


        <div class="container" style="background-color: transparent;">
            <div class="text-center">
                <img src="/clipbrd/images/drawstringxyz.png" class="img-responsive img-thumbnail">
                <h1>快捷的在线剪贴板</h1>
                <p>快速从电脑复制大段文本、坐标、网址等内容到手机,15分钟无人使用后自动删除。</p>

                <div class="row site-index-parts">
                    <div class="col-sm-6">
                        <h2>创建</h2>
                        <p>新建一块用于电脑和手机之间复制粘贴的在线空间。</p>
                        <p><a class="btn btn-lg btn-primary" href="create" titile="贴一块">贴一块</a></p>
                    </div>
                    <div class="col-sm-6">
                        <h2>查找</h2>
                        <p>根据识别码查找一块已经存在的在线空间。</p>
                        <p><a class="btn btn-lg btn-success" href="find" titile="找一块">找一块</a></p>
                    </div>
                </div>
            </div>
        </div>


        <div class="text-center">
            <%@ include file="footer.jsp" %>
        </div>
    </div>
</body>
</html>