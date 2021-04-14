<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Cute Banking System</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700,800,900&display=swap"
          rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css"/>"/>--%>

    <!-- Extended CSS resources -->
    <%--    <link rel="icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/pages/waves/css/waves.min.css"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/bootstrap/css/bootstrap.min.css"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/pages/waves/css/waves.min.css"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/icon/themify-icons/themify-icons.css"/>">--%>
    <%--    &lt;%&ndash;<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/font-awesome-n.min.css"/>">&ndash;%&gt;--%>
    <%--    &lt;%&ndash;<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/font-awesome.min.css" />">&ndash;%&gt;--%>
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome.min.css"/>">--%>

    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/jquery.mCustomScrollbar.css" />">--%>


    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/style.css"/>">--%>
    <!-- Custom styles for this page -->
</head>
<body>
<!-- Pre-loader start -->
<%--<div class="theme-loader">--%>
<%--    <div class="loader-track">--%>
<%--        <div class="preloader-wrapper">--%>
<%--            <div class="spinner-layer spinner-blue">--%>
<%--                <div class="circle-clipper left">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="gap-patch">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="circle-clipper right">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="spinner-layer spinner-red">--%>
<%--                <div class="circle-clipper left">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="gap-patch">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="circle-clipper right">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="spinner-layer spinner-yellow">--%>
<%--                <div class="circle-clipper left">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="gap-patch">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="circle-clipper right">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="spinner-layer spinner-green">--%>
<%--                <div class="circle-clipper left">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="gap-patch">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--                <div class="circle-clipper right">--%>
<%--                    <div class="circle"></div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- Pre-loader end -->
<nav class="pcoded-navbar">
    <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
    <div class="pcoded-inner-navbar main-menu">
        <div class="">
            <div class="main-menu-header">
                <img class="img-80 img-radius" src="<c:url value="resources/img/avatar-4.jpg" />"
                     alt="User-Profile-Image">
                <div class="user-details">
                    <span id="more-details">Admin<i class="fa fa-caret-down"></i></span>
                </div>
            </div>
            <div class="main-menu-content">
                <ul>
                    <li class="more-details">
                        <a href="admin-profile"><i class="ti-user"></i>View Profile</a>
                        <a href="#!"><i class="ti-settings"></i>Settings</a>
                        <a href="auth-normal-sign-in.html"><i class="ti-layout-sidebar-left"></i>Logout</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="p-15 p-b-0">
            <form class="form-material">
                <div class="form-group form-primary">
                    <input type="text" name="footer-email" class="form-control">
                    <span class="form-bar"></span>
                    <label class="float-label"><i class="fa fa-search m-r-10"></i>Search Friend</label>
                </div>
            </form>
        </div>
        <div class="pcoded-navigation-label">Navigation</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="active">
                <a href="/" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                    <span class="pcoded-mtext">Dashboard</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
        </ul>
        <div class="pcoded-navigation-label">Customer</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i><b>BC</b></span>
                    <span class="pcoded-mtext">Manage Customer</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class=" ">
                        <a href="/create-customer" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Add Customer</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="/customer-list" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Customer List</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="pcoded-navigation-label">Transaction</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i><b>BC</b></span>
                    <span class="pcoded-mtext">Transfer Transaction</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class=" ">
                        <a href="/create-transfer" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Add Transfer Transaction</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="/transfer-list" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Transfer Transaction List</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>
        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i><b>BC</b></span>
                    <span class="pcoded-mtext">Withdraw Transaction</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class=" ">
                        <a href="/create-withdraw" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Add Withdraw Transaction</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="/withdraw-list" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Withdraw Transaction List</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>
        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i><b>BC</b></span>
                    <span class="pcoded-mtext">Charge Transaction</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class=" ">
                        <a href="/create-charge" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Add Charge Transaction</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="/charge-list" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Charge Transaction List</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>

    </div>
</nav>
<!-- Required Jquery -->
<%--<script type="text/javascript" src="resources/js/admin/jquery/jquery.min.js "></script>--%>
<%--<script type="text/javascript" src="resources/js/admin/jquery-ui/jquery-ui.min.js "></script>--%>
<%--<script type="text/javascript" src="resources/js/admin/popper.js/popper.min.js"></script>--%>
<%--<script type="text/javascript" src="resources/js/admin/bootstrap/js/bootstrap.min.js "></script>--%>
<%--<!-- waves js -->--%>
<%--<script src="resources/pages/waves/js/waves.min.js"></script>--%>
<%--<!-- jquery slimscroll js -->--%>
<%--<script type="text/javascript" src="resources/js/admin/jquery-slimscroll/jquery.slimscroll.js"></script>--%>

<%--<!-- slimscroll js -->--%>
<%--<script src="resources/js/admin/jquery.mCustomScrollbar.concat.min.js "></script>--%>

<%--<!-- menu js -->--%>
<%--<script src="resources/js/admin/pcoded.min.js"></script>--%>
<%--<script src="resources/js/admin/vertical/vertical-layout.min.js "></script>--%>

<%--<script type="text/javascript" src="resources/js/admin/script.js "></script>--%>
</body>
</html>
