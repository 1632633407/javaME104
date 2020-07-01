<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/1
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <title>用户列表</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../../assets/images/favicon.png">
    <!-- Bootstrap Core CSS -->
    <link href="../../../assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="../../../css/adminstyle.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="../../../css/colors/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="fix-header card-no-border">
<!-- ============================================================== -->
<!-- Preloader - style you can find in spinners.css -->
<!-- ============================================================== -->
<div class="preloader">
    <svg class="circular" viewBox="25 25 50 50">
        <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
    </svg>
</div>
<!-- ============================================================== -->
<!-- Main wrapper - style you can find in pages.scss -->
<!-- ============================================================== -->
<div id="main-wrapper">
    <!-- ============================================================== -->
    <!-- Topbar header - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <header class="topbar">
        <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
            <!-- ============================================================== -->
            <!-- Logo -->
            <!-- ============================================================== -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <!-- Logo icon -->
                    <b>
                        <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                        <!-- Dark Logo icon -->
                        <img src="../../../assets/images/logo-icon.png" alt="homepage" class="dark-logo"/>

                    </b>
                    <!--End Logo icon -->
                    <!-- Logo text -->
                    <span>
                            <!-- dark Logo text -->
                            <img src="../../../assets/images/logo-text.png" alt="homepage" class="dark-logo"/>
                        </span>
                </a>
            </div>
            <!-- ============================================================== -->
            <!-- End Logo -->
            <!-- ============================================================== -->
            <div class="navbar-collapse">
                <!-- ============================================================== -->
                <!-- toggle and nav items -->
                <!-- ============================================================== -->
                <ul class="navbar-nav mr-auto mt-md-0 ">
                    <!-- This is  -->
                    <li class="nav-item"><a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark"
                                            href="javascript:void(0)"><i class="ti-menu"></i></a></li>
                </ul>
                <!-- ============================================================== -->
                <!-- User profile and search -->
                <!-- ============================================================== -->
                <ul class="navbar-nav my-lg-0">
                    <li class="nav-item dropdown">
                        <a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- ============================================================== -->
    <!-- End Topbar header -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <aside class="left-sidebar">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
            <!-- Sidebar navigation-->
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/userManager.do" class="waves-effect"><i
                                class="fa fa-user m-r-10"
                                aria-hidden="true"></i>用户管理</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/movieManager.do" class="waves-effect"><i
                                class="fa fa-table m-r-10"
                                aria-hidden="true"></i>电影管理</a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/admin/classManager.do" class="waves-effect"><i
                            class="fa fa-table m-r-10"
                            aria-hidden="true"></i>电影分类管理</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/allLog.do" class="waves-effect"><i
                                class="fa fa-info-circle m-r-10"
                                aria-hidden="true"></i>操作记录</a>
                    </li>
                </ul>
            </nav>
            <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
    </aside>
    <!-- ============================================================== -->
    <!-- End Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Page wrapper  -->
    <!-- ============================================================== -->
    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
            <div class="row">
                <!-- column -->
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-block">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>用户名</th>
                                        <th>操作</th>
                                        <th>操作时间</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="log">
                                        <tr>
                                            <td>${log.id}</td>
                                            <td>${log.uName}</td>
                                            <td>${log.option}</td>
                                            <td><fmt:formatDate value="${log.time}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tr>
                                        <td colspan="4">
                                            第${pageInfo.pageNum}页，共${pageInfo.pages}页，共${pageInfo.total}条记录
                                            <c:if test="${pageInfo.isFirstPage ==false}">
                                                <a href="${pageContext.request.contextPath}/admin/pageLog?pageNum=1">
                                                    首页
                                                </a>
                                            </c:if>
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <a href="${pageContext.request.contextPath}/admin/pageLog?pageNum=${pageInfo.pageNum-1}">
                                                    上一页 &nbsp;
                                                </a>
                                            </c:if>
                                            <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                                <c:if test="${page==pageInfo.pageNum}">
                                                    <a style="color: red"
                                                       href="${pageContext.request.contextPath}/admin/pageLog?pageNum=${page}">
                                                            &nbsp;${page} &nbsp;
                                                    </a>

                                                </c:if>
                                                <c:if test="${page!=pageInfo.pageNum}">
                                                    <a href="${pageContext.request.contextPath}/admin/pageLog?pageNum=${page}">
                                                        &nbsp;${page} &nbsp;
                                                    </a>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <a href="${pageContext.request.contextPath}/admin/pageLog?pageNum=${pageInfo.pageNum+1}">
                                                    下一页 &nbsp;
                                                </a>

                                            </c:if>
                                            <c:if test="${pageInfo.isLastPage==false}">
                                                <a href="${pageContext.request.contextPath}/admin/pageLog?pageNum=${pageInfo.pages}">
                                                    尾页
                                                </a>
                                            </c:if>

                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End PAge Content -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Container fluid  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Page wrapper  -->
    <!-- ============================================================== -->
</div>
<!-- ============================================================== -->
<!-- End Wrapper -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- All Jquery -->
<!-- ============================================================== -->
<script src="../../../assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="../../../assets/plugins/bootstrap/js/tether.min.js"></script>
<script src="../../../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- slimscrollbar scrollbar JavaScript -->
<script src="../../../js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="../../../js/waves.js"></script>
<!--Menu sidebar -->
<script src="../../../js/sidebarmenu.js"></script>
<!--stickey kit -->
<script src="../../../assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
<!--Custom JavaScript -->
<script src="../../../js/custom.min.js"></script>
<!-- ============================================================== -->
<!-- Style switcher -->
<!-- ============================================================== -->
<script src="../../../assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>

