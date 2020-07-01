<%@ page import="com.pyl.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/1
  Time: 16:29
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
<h1>修改密码</h1>
<div class="login-form" style="height: auto">
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="avtar">
        <img src="images/avtar.png"/>
    </div>
    <form id="registForm" action="${pageContext.request.contextPath}/user/uppassword.do" method="post">
        <input type="text" name="uPwd" placeholder="密码" required/>
         <div class="signin">
            <input type="submit" value="确认修改">
        </div>
    </form>
</div>
</body>
</html>
