<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<meta charset="ISO-8859-1">
<title>Cute Banking System</title>

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700,800,900&display=swap"
      rel="stylesheet">

<!-- Bootstrap core CSS -->
<%--<link rel="stylesheet" type="text/css" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css"/>"/>--%>

<!-- Extended CSS resources -->
<link rel="icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico"/>">
<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/pages/waves/css/waves.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/bootstrap/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/pages/waves/css/waves.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/icon/themify-icons/themify-icons.css"/>">
<%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/font-awesome-n.min.css"/>">--%>
<%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/font-awesome.min.css" />">--%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/jquery.mCustomScrollbar.css" />">


<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/style.css"/>">
<!-- Custom styles for this page -->
</head>
<body>
<!-- Pre-loader start -->
<div class="theme-loader">
    <div class="loader-track">
        <div class="preloader-wrapper">
            <div class="spinner-layer spinner-blue">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
            <div class="spinner-layer spinner-red">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>

            <div class="spinner-layer spinner-yellow">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>

            <div class="spinner-layer spinner-green">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Pre-loader end -->
<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">
        <nav class="navbar header-navbar pcoded-header">
            <div class="navbar-wrapper">
                <div class="navbar-logo">
                    <a class="mobile-menu waves-effect waves-light" id="mobile-collapse" href="#!">
                        <i class="ti-menu"></i>
                    </a>
                    <div class="mobile-search waves-effect waves-light">
                        <div class="header-search">
                            <div class="main-search morphsearch-search">
                                <div class="input-group">
                                    <span class="input-group-prepend search-close"><i
                                            class="ti-close input-group-text"></i></span>
                                    <input type="text" class="form-control" placeholder="Enter Keyword">
                                    <span class="input-group-append search-btn"><i
                                            class="ti-search input-group-text"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a href="/">
                        <img class="img-fluid" src="<c:url value="resources/img/codersBank-logo.png"/>"
                             alt="Theme-Logo"/>
                    </a>
                    <a class="mobile-options waves-effect waves-light">
                        <i class="ti-more"></i>
                    </a>
                </div>
                <div class="navbar-container container-fluid">
                    <ul class="nav-left">
                        <li>
                            <div class="sidebar_toggle"><a href="javascript:void(0)"><i class="ti-menu"></i></a></div>
                        </li>
                        <li>
                            <a href="#!" onclick="javascript:toggleFullScreen()" class="waves-effect waves-light">
                                <i class="ti-fullscreen"></i>
                            </a>
                        </li>
                    </ul>
                    <ul class="nav-right">
                        <li class="header-notification">
                            <a href="#!" class="waves-effect waves-light">
                                <i class="ti-bell"></i>
                                <span class="badge bg-c-red"></span>
                            </a>
                            <ul class="show-notification">
                                <li>
                                    <h6>Notifications</h6>
                                    <label class="label label-danger">New</label>
                                </li>
                                <li class="waves-effect waves-light">
                                    <div class="media">
                                        <img class="d-flex align-self-center img-radius"
                                             src="<c:url value="resources/img/avatar-2.jpg" />"
                                             alt="Generic placeholder image">
                                        <div class="media-body">
                                            <h5 class="notification-user">Admin</h5>
                                            <p class="notification-msg">Lorem ipsum dolor sit amet, consectetuer
                                                elit.</p>
                                            <span class="notification-time">30 minutes ago</span>
                                        </div>
                                    </div>
                                </li>
                                <li class="waves-effect waves-light">
                                    <div class="media">
                                        <img class="d-flex align-self-center img-radius"
                                             src="<c:url value="resources/img/avatar-4.jpg" />"
                                             alt="Generic placeholder image">
                                        <div class="media-body">
                                            <h5 class="notification-user">Joseph William</h5>
                                            <p class="notification-msg">Lorem ipsum dolor sit amet, consectetuer
                                                elit.</p>
                                            <span class="notification-time">30 minutes ago</span>
                                        </div>
                                    </div>
                                </li>
                                <li class="waves-effect waves-light">
                                    <div class="media">
                                        <img class="d-flex align-self-center img-radius"
                                             src="<c:url value="resources/img/avatar-3.jpg" />"
                                             alt="Generic placeholder image">
                                        <div class="media-body">
                                            <h5 class="notification-user">Sara Soudein</h5>
                                            <p class="notification-msg">Lorem ipsum dolor sit amet, consectetuer
                                                elit.</p>
                                            <span class="notification-time">30 minutes ago</span>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li class="user-profile header-notification">
                            <a href="#!" class="waves-effect waves-light">
                                <img src="<c:url value="resources/img/avatar-4.jpg" />" class="img-radius"
                                     alt="User-Profile-Image">
                                <span>Admin</span>
                                <i class="ti-angle-down"></i>
                            </a>
                            <ul class="show-notification profile-notification">
                                <li class="waves-effect waves-light">
                                    <a href="#!">
                                        <i class="ti-settings"></i> Settings
                                    </a>
                                </li>
                                <li class="waves-effect waves-light">
                                    <a href="user-profile.html">
                                        <i class="ti-user"></i> Profile
                                    </a>
                                </li>
                                <li class="waves-effect waves-light">
                                    <a href="email-inbox.html">
                                        <i class="ti-email"></i> My Messages
                                    </a>
                                </li>
                                <li class="waves-effect waves-light">
                                    <a href="auth-lock-screen.html">
                                        <i class="ti-lock"></i> Lock Screen
                                    </a>
                                </li>
                                <li class="waves-effect waves-light">
                                    <a href="auth-normal-sign-in.html">
                                        <i class="ti-layout-sidebar-left"></i> Logout
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <jsp:include page="../common-sidebar.jsp"></jsp:include>

                <div class="pcoded-content">
                    <!-- Page-header start -->
                    <div class="page-header">
                        <div class="page-block">
                            <div class="row align-items-center">
                                <div class="col-md-8">
                                    <div class="page-header-title">
                                        <h5 class="m-b-10">Dashboard</h5>
                                        <p class="m-b-0">Welcome Admin!</p>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item">
                                            <a href="/"> <i class="fa fa-home"></i> </a>
                                        </li>
                                        <li class="breadcrumb-item"><a href="#!">Dashboard</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Page-header end -->
                    <div class="pcoded-inner-content">
                        <!-- Main-body start -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- Page-body start -->
                                <div class="page-body">
                                    <div class="row">
                                        <!-- Material statustic card start -->
                                        <div class="col-xl-4 col-md-12">
                                            <div class="card mat-stat-card">
                                                <div class="card-block">
                                                    <div class="row align-items-center b-b-default">
                                                        <div class="col-sm-6 b-r-default p-b-20 p-t-20">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="far fa-user text-c-purple f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>10K</h5>
                                                                    <p class="text-muted m-b-0">Visitors</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6 p-b-20 p-t-20">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="fas fa-volume-down text-c-green f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>100%</h5>
                                                                    <p class="text-muted m-b-0">Volume</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row align-items-center">
                                                        <div class="col-sm-6 p-b-20 p-t-20 b-r-default">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="far fa-file-alt text-c-red f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>2000+</h5>
                                                                    <p class="text-muted m-b-0">Files</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6 p-b-20 p-t-20">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="far fa-envelope-open text-c-blue f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>120</h5>
                                                                    <p class="text-muted m-b-0">Mails</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-4 col-md-12">
                                            <div class="card mat-stat-card">
                                                <div class="card-block">
                                                    <div class="row align-items-center b-b-default">
                                                        <div class="col-sm-6 b-r-default p-b-20 p-t-20">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="fas fa-share-alt text-c-purple f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>1000</h5>
                                                                    <p class="text-muted m-b-0">Share</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6 p-b-20 p-t-20">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="fas fa-sitemap text-c-green f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>600</h5>
                                                                    <p class="text-muted m-b-0">Network</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row align-items-center">
                                                        <div class="col-sm-6 p-b-20 p-t-20 b-r-default">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="fas fa-signal text-c-red f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>350</h5>
                                                                    <p class="text-muted m-b-0">Returns</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6 p-b-20 p-t-20">
                                                            <div class="row align-items-center text-center">
                                                                <div class="col-4 p-r-0">
                                                                    <i class="fas fa-wifi text-c-blue f-24"></i>
                                                                </div>
                                                                <div class="col-8 p-l-0">
                                                                    <h5>100%</h5>
                                                                    <p class="text-muted m-b-0">Connections</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-4 col-md-12">
                                            <div class="card mat-clr-stat-card text-white green ">
                                                <div class="card-block">
                                                    <div class="row">
                                                        <div class="col-3 text-center bg-c-green">
                                                            <i class="fas fa-star mat-icon f-24"></i>
                                                        </div>
                                                        <div class="col-9 cst-cont">
                                                            <h5>4000+</h5>
                                                            <p class="m-b-0">Ratings Received</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card mat-clr-stat-card text-white blue">
                                                <div class="card-block">
                                                    <div class="row">
                                                        <div class="col-3 text-center bg-c-blue">
                                                            <i class="fas fa-trophy mat-icon f-24"></i>
                                                        </div>
                                                        <div class="col-9 cst-cont">
                                                            <h5>17</h5>
                                                            <p class="m-b-0">Achievements</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Material statustic card end -->
                                        <!-- order-visitor start -->


                                        <!-- order-visitor end -->

                                        <!--  sale analytics start -->
                                        <div class="col-xl-6 col-md-12">
                                            <div class="card table-card">
                                                <div class="card-header">
                                                    <h5>Member's performance</h5>
                                                    <div class="card-header-right">
                                                        <ul class="list-unstyled card-option">
                                                            <li><i class="fa fa fa-wrench open-card-option"></i></li>
                                                            <li><i class="fa fa-window-maximize full-card"></i></li>
                                                            <li><i class="fa fa-minus minimize-card"></i></li>
                                                            <li><i class="fa fa-refresh reload-card"></i></li>
                                                            <li><i class="fa fa-trash close-card"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="card-block">
                                                    <div class="table-responsive">
                                                        <table class="table table-hover m-b-0 without-header">
                                                            <tbody>
                                                            <tr>
                                                                <td>
                                                                    <div class="d-inline-block align-middle">
                                                                        <img src="<c:url value="resources/img/avatar-4.jpg" />"
                                                                             alt="user image"
                                                                             class="img-radius img-40 align-top m-r-15">
                                                                        <div class="d-inline-block">
                                                                            <h6>Shirley Hoe</h6>
                                                                            <p class="text-muted m-b-0">Sales executive
                                                                                , NY</p>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td class="text-right">
                                                                    <h6 class="f-w-700">$78.001<i
                                                                            class="fas fa-level-down-alt text-c-red m-l-10"></i>
                                                                    </h6>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="d-inline-block align-middle">
                                                                        <img src="<c:url value="resources/img/avatar-2.jpg" />"
                                                                             alt="user image"
                                                                             class="img-radius img-40 align-top m-r-15">
                                                                        <div class="d-inline-block">
                                                                            <h6>James Alexander</h6>
                                                                            <p class="text-muted m-b-0">Sales executive
                                                                                , EL</p>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td class="text-right">
                                                                    <h6 class="f-w-700">$89.051<i
                                                                            class="fas fa-level-up-alt text-c-green m-l-10"></i>
                                                                    </h6>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="d-inline-block align-middle">
                                                                        <img src="<c:url value="resources/img/avatar-4.jpg" />"
                                                                             alt="user image"
                                                                             class="img-radius img-40 align-top m-r-15">
                                                                        <div class="d-inline-block">
                                                                            <h6>Shirley Hoe</h6>
                                                                            <p class="text-muted m-b-0">Sales executive
                                                                                , NY</p>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td class="text-right">
                                                                    <h6 class="f-w-700">$89.051<i
                                                                            class="fas fa-level-up-alt text-c-green m-l-10"></i>
                                                                    </h6>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="d-inline-block align-middle">
                                                                        <img src="<c:url value="resources/img/avatar-2.jpg" />"
                                                                             alt="user image"
                                                                             class="img-radius img-40 align-top m-r-15">
                                                                        <div class="d-inline-block">
                                                                            <h6>Nick Xander</h6>
                                                                            <p class="text-muted m-b-0">Sales executive
                                                                                , EL</p>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td class="text-right">
                                                                    <h6 class="f-w-700">$89.051<i
                                                                            class="fas fa-level-up-alt text-c-green m-l-10"></i>
                                                                    </h6>
                                                                </td>
                                                            </tr>
                                                            </tbody>
                                                        </table>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-md-12">
                                            <div class="row">
                                                <!-- sale card start -->

                                                <div class="col-md-6">
                                                    <div class="card text-center order-visitor-card">
                                                        <div class="card-block">
                                                            <h6 class="m-b-0">Total Subscription</h6>
                                                            <h4 class="m-t-15 m-b-15"><i
                                                                    class="fa fa-arrow-down m-r-15 text-c-red"></i>7652
                                                            </h4>
                                                            <p class="m-b-0">48% From Last 24 Hours</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="card text-center order-visitor-card">
                                                        <div class="card-block">
                                                            <h6 class="m-b-0">Order Status</h6>
                                                            <h4 class="m-t-15 m-b-15"><i
                                                                    class="fa fa-arrow-up m-r-15 text-c-green"></i>6325
                                                            </h4>
                                                            <p class="m-b-0">36% From Last 6 Months</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="card bg-c-red total-card">
                                                        <div class="card-block">
                                                            <div class="text-left">
                                                                <h4>489</h4>
                                                                <p class="m-0">Total Comment</p>
                                                            </div>
                                                            <span class="label bg-c-red value-badges">15%</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="card bg-c-green total-card">
                                                        <div class="card-block">
                                                            <div class="text-left">
                                                                <h4>$5782</h4>
                                                                <p class="m-0">Income Status</p>
                                                            </div>
                                                            <span class="label bg-c-green value-badges">20%</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="card text-center order-visitor-card">
                                                        <div class="card-block">
                                                            <h6 class="m-b-0">Unique Visitors</h6>
                                                            <h4 class="m-t-15 m-b-15"><i
                                                                    class="fa fa-arrow-down m-r-15 text-c-red"></i>652
                                                            </h4>
                                                            <p class="m-b-0">36% From Last 6 Months</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="card text-center order-visitor-card">
                                                        <div class="card-block">
                                                            <h6 class="m-b-0">Monthly Earnings</h6>
                                                            <h4 class="m-t-15 m-b-15"><i
                                                                    class="fa fa-arrow-up m-r-15 text-c-green"></i>5963
                                                            </h4>
                                                            <p class="m-b-0">36% From Last 6 Months</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- sale card end -->
                                            </div>
                                        </div>

                                        <!--  sale analytics end -->

                                        <!-- Project statustic start -->
                                        <div class="col-xl-12">
                                            <div class="card proj-progress-card">
                                                <div class="card-block">
                                                    <div class="row">
                                                        <div class="col-xl-3 col-md-6">
                                                            <h6>Published Project</h6>
                                                            <h5 class="m-b-30 f-w-700">532<span
                                                                    class="text-c-green m-l-10">+1.69%</span></h5>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-c-red"
                                                                     style="width:25%"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-xl-3 col-md-6">
                                                            <h6>Completed Task</h6>
                                                            <h5 class="m-b-30 f-w-700">4,569<span
                                                                    class="text-c-red m-l-10">-0.5%</span></h5>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-c-blue"
                                                                     style="width:65%"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-xl-3 col-md-6">
                                                            <h6>Successfull Task</h6>
                                                            <h5 class="m-b-30 f-w-700">89%<span
                                                                    class="text-c-green m-l-10">+0.99%</span></h5>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-c-green"
                                                                     style="width:85%"></div>
                                                            </div>
                                                        </div>
                                                        <div class="col-xl-3 col-md-6">
                                                            <h6>Ongoing Project</h6>
                                                            <h5 class="m-b-30 f-w-700">365<span
                                                                    class="text-c-green m-l-10">+0.35%</span></h5>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-c-yellow"
                                                                     style="width:45%"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Project statustic end -->
                                    </div>
                                </div>
                                <!-- Page-body end -->
                            </div>
                            <div id="styleSelector"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Required Jquery -->
<script type="text/javascript" src="resources/js/admin/jquery/jquery.min.js "></script>
<script type="text/javascript" src="resources/js/admin/jquery-ui/jquery-ui.min.js "></script>
<script type="text/javascript" src="resources/js/admin/popper.js/popper.min.js"></script>
<script type="text/javascript" src="resources/js/admin/bootstrap/js/bootstrap.min.js "></script>
<!-- waves js -->
<script src="resources/pages/waves/js/waves.min.js"></script>
<!-- jquery slimscroll js -->
<script type="text/javascript" src="resources/js/admin/jquery-slimscroll/jquery.slimscroll.js"></script>

<!-- slimscroll js -->
<script src="resources/js/admin/jquery.mCustomScrollbar.concat.min.js "></script>

<!-- menu js -->
<script src="resources/js/admin/pcoded.min.js"></script>
<script src="resources/js/admin/vertical/vertical-layout.min.js "></script>

<script type="text/javascript" src="resources/js/admin/script.js "></script>
</body>

</html>

