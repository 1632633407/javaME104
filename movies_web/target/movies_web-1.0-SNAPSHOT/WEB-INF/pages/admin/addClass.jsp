<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/3
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../../../js/jquery.min.js"></script>
<html>
<head>
    <title>添加分类</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/insertClass.do" method="post" enctype="multipart/form-data">
    <p>请输入需要添加的分类:<input type="text" name="mName"required></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
