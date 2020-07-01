<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/3
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../../js/jquery.min.js"></script>
    <title>电影上传</title>
</head>
<body>
<h2>上传电影</h2>
<form action="${pageContext.request.contextPath}/admin/filesUpload.do" method="post" enctype="multipart/form-data">
    <p>电影名称:<label>
        <input type="text" name="vName" required>
    </label></p>
    <p>选择视频文件:<input type="file" name="movie " required></p>
    <p>选择电影封面文件:<input type="file" name="picture" required></p>
    <p>填写电影简介:<label>
        <textarea name="vInfo" id="vInfo" cols="30" rows="10" required maxlength="200"></textarea>
    </label></p>
    <p>选择电影分类:
        <label>
            <select name="mName" required>
                <option value="">请选择</option>
                <c:forEach items="${mclasses}" var="mclass">
                    <option value="${mclass.mId}">${mclass.mName}</option>
                </c:forEach>
            </select>
        </label>
    </p>
    <p>是否需要VIP:
        <label>
        <select name="isVip" required>
            <option value="0">不需要</option>
            <option value="1">需要</option>
        </select>
    </label></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
