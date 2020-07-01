<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/17
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="${pageContext.request.contextPath}js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/style.css" rel='stylesheet' type='text/css'/>

</head>
<body>
<script>
    $(document).ready(function (c) {
        $('.close').on('click', function (c) {
            $('.login-form').fadeOut('slow', function (c) {
                $('.login-form').remove();
            });
        });
    });
</script>
<!--SIGN UP-->
<h1>欢迎登录影视资源管理系统</h1>
<div class="login-form">
    <%--登录窗关闭按钮屏蔽--%>
    <%--<div class="close"></div>--%>
    <div class="head-info">
    <a href="${pageContext.request.contextPath}/user/registmain.do">新用户注册</a>
        <a href="${pageContext.request.contextPath}/admin/loginmain.do">管理员登录</a>
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"></div>
    <div class="avtar">
        <img src="${pageContext.request.contextPath}/images/avtar.png"/>
    </div>
    <form action="${pageContext.request.contextPath}/user/login.do" method="post">
        <input aria-label="用户名" type="text" name="username" class="text" placeholder="Username" required/>
        <div class="key">
            <input type="password" name="password" placeholder="Password" required/>
        </div>

        <div class="signin">
            <input type="submit" value="Login">
        </div>
    </form>
</div>
</body>
</html>
