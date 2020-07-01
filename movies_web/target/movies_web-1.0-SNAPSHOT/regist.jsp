<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/28
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/style.css" rel='stylesheet' type='text/css'/>

    <script type="text/javascript">
        $().ready(function() {
            $("#registForm").validate({
                submitHandler:function(form){
                    form.submit();
                }
            });
        });
    </script>
</head>
<body>
<h1>欢迎注册影视资源管理系统</h1>
<div class="login-form" style="height: auto">
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="avtar">
        <img src="${pageContext.request.contextPath}/images/avtar.png"/>
    </div>
    <form id="registForm" action="${pageContext.request.contextPath}/user/regist.do" method="post">
        <input type="text" name="uName" class="text" placeholder="用户名" required/>
        <input type="text" name="uPwd" placeholder="密码" required/>
        <input type="text" name="uQQ" placeholder="QQ" required/>
        <input type="text" name="uEmail" placeholder="邮箱" required/>
        <input type="text" name="uSex" placeholder="性别" onblur="if (this.value==='男'||this.value==='女'){ return; }this.value='保密';" required>
        <div class="signin">
            <input type="submit" value="确认注册">
        </div>
    </form>
</div>
</body>
</html>
