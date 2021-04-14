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
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/icon/icofont/css/icofont.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/jquery.mCustomScrollbar.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/jquery.mCustomScrollbar.css" />">


<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/style.css"/>">
<!-- Custom styles for this page -->
</head>
<body>
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
                <%--                <jsp:include page="common-navbar.jsp"></jsp:include>--%>
                <jsp:include page="../common-sidebar.jsp"></jsp:include>
                <div class="pcoded-content">
                    <!-- Page-header start -->
                    <div class="page-header">
                        <div class="page-block">
                            <div class="row align-items-center">
                                <div class="col-md-8">
                                    <div class="page-header-title">
                                        <h3 class="m-b-10">Add A New Customer</h3>
<%--                                        <p class="m-b-0">Lorem Ipsum is simply dummy text of the printing</p>--%>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item">
                                            <a href="index.html"> <i class="fa fa-home"></i> </a>
                                        </li>
                                        <li class="breadcrumb-item"><a href="#!">Manage Customer</a>
                                        </li>
                                        <li class="breadcrumb-item"><a href="#!">Add Customer</a>
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

                                <!-- Page body start -->
                                <div class="page-body">
                                    <div class="row h-100 justify-content-center align-items-center">
                                        <div class="col-md-6">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h5>Add a new customer</h5>
                                                    <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
                                                </div>
                                                <div class="card-block">
                                                    <form class="form-material">
                                                        <div class="form-group form-default">
                                                            <input type="number" name="customerId" class="form-control" disabled>
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Customer ID</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="fullName" class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Full Name</label>
                                                        </div>
                                                        <div class="form-group form-default form-static-label">
                                                            <input type="date" name="dob"
                                                                   class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Date Of Birth</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <label class="col-sm-4 col-form-label">Gender</label>
                                                            <div class="col-sm-12">
                                                                <select name="select" class="form-control" name="gender">
                                                                    <option value="male">Male</option>
                                                                    <option value="female">Female</option>
                                                                    <option value="others">Others</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="address" class="form-control"
                                                                >
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Address</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="phoneNumber" class="form-control"
                                                            >
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Phone Number</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="accountNumber" class="form-control"
                                                            >
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Account Number</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="balance" class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Balance</label>
                                                        </div>
<%--                                                        <div class="form-group form-default">--%>
<%--                                                            <label class="col-sm-4 col-form-label">Type of Account</label>--%>
<%--                                                            <div class="col-sm-12">--%>
<%--                                                                <select name="select" class="form-control" name="accountType">--%>
<%--                                                                    <option value="normalAccount">Normal Account</option>--%>
<%--                                                                    <option value="savingAccount">Saving Account</option>--%>
<%--                                                                    <option value="loanAccount">Loan Account</option>--%>
<%--                                                                </select>--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
                                                        <div class="button">
                                                            <button type="submit" class="btn btn-primary">Add</button>
                                                            &ensp;&ensp;&ensp;
                                                            <button type="submit" class="btn btn-danger">Cancel</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                                </div>
                                <!-- Page body end -->
                            </div>
                        </div>
                        <!-- Main-body end -->
                        <div id="styleSelector">

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

<!-- Custom js -->
<script src="resources/js/admin/pcoded.min.js"></script>
<script src="resources/js/admin/vertical/vertical-layout.min.js"></script>
<script src="resources/js/admin/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript" src="resources/js/admin/script.js"></script>

</body>
</html>