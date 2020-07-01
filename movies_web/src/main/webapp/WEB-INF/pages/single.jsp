<%@ page import="com.pyl.pojo.Video" %>
<%@ page import="com.pyl.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/30
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>电影资源管理系统</title>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css" type="text/css">

    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="../../css/jquery.smartmenus.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="../../css/indexstyle.css">

    <!-- Custom Fonts -->
    <link rel="stylesheet" href="../../font-awesome-4.4.0/css/font-awesome.min.css" type="text/css">

    <link rel="stylesheet" href="../../css/lightbox.css">

    <!-- Core JavaScript Files -->
    <script src="../../js/bootstrap.min.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../../js/html5shiv.js"></script>
    <script src="../../js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Static navbar -->
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">电影资源网</a>
    </div>
    <div class="navbar-collapse collapse">
        <!-- Left nav -->
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/movie/mvlist.do"><i class="fa fa-home"></i> 首页</a></li>
            <li><a href="http://www.baidu.com">友情链接</a></li>
            <li><a href="#" class="dropup"><i class="fa fa-user"></i> 账户</a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/uppassword.jsp">修改密码</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/logout.do">注销</a></li>
                </ul>
            </li>
            <li><a href="#" class="dropup"><i class="fa fa-list"></i> 菜单</a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/movie/mvlistF.do">精选</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">导航</li>
                    <li><a href="#">分类<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${classes}" var="cs">
                                <li>
                                    <a href="${pageContext.request.contextPath}/vclass/clist.do?class=${cs.mId}">${cs.mName}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-left" method="post" action="${pageContext.request.contextPath}/movie/findOne.do"
              role="search">
            <div class="form-group">
                <input type="text" class="form-control" name="keyword" placeholder="关键词">
            </div>
            <button type="submit" class="btn btn-search">搜索</button>
        </form>
        <!-- Right nav -->
        <ul class="nav navbar-nav navbar-right top-social list-inline" style="padding: 0;margin: 0;">
            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
            <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
            <li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
            <li><a href="#"><i class="fa fa-youtube"></i></a></li>
        </ul>

    </div><!--/.nav-collapse -->
</div>

<header>
    <div class="logo">
        <a href="${pageContext.request.contextPath}/user/index.do"><img src="../../images/logo.png"></a>
    </div>
</header>

<div id="page-content" class="sub-page">
    <div class="container">
        <center>
            <article>
                <a class="example-image-link" href="#">
                    <img class="example-image" src="${movie.vImg}" alt=""/></a>
                <div class="content-item">
                    <span class="time"><a class="btn btn-1">${movie.mName}</a> </span>
                    <h3 class="title-item">电影名：<a href="#">${movie.vName}</a></h3>
                    <ul class="list-inline">
                        <li><a href="#">浏览量:<i class="fa fa-eye"></i> ${movie.vCount}</a></li>
                        <c:if test="${movie.isVip=='0'}">
                            <li><a href="${movie.vUrl}"><i class="fa fa-download"></i>下载</a></li>
                        </c:if>
                        <c:if test="${movie.isVip=='1'&&user.uStauts=='2'}">
                            <li><a href="${movie.vUrl}"><i class="fa fa-download"></i>下载</a></li>
                        </c:if>
                    </ul>
                    <p class="info">${movie.vInfo}</p>
                </div>
            </article>
        </center>
    </div>
</div>

<!-- Once the page is loaded, initialized the plugin. -->
<script type="text/javascript" src="../../js/jquery-2.1.1.js"></script>
<script src="../../js/bootstrap.min.js"></script>

<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="../../js/jquery.smartmenus.js"></script>

<!-- SmartMenus jQuery Bootstrap Addon -->
<script type="text/javascript" src="../../js/jquery.smartmenus.bootstrap.js"></script>

<script src="../../js/lightbox-plus-jquery.min.js"></script>
</body>
</html>
