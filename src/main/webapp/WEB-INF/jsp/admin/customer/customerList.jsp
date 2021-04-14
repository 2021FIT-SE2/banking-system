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
        <jsp:include page="../common-navbar.jsp"></jsp:include>

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
                                        <h3 class="m-b-10">List of Customers</h3>
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
                                        <li class="breadcrumb-item"><a href="#!">Customer List</a>
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
                                    <div class="card">
                                        <div class="card-header">
                                            <h5>List of Customers</h5>
<%--                                            <span>use class <code>table-hover</code> inside table element</span>--%>
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
                                        <div class="card-block table-border-style">
                                            <div class="table-responsive">
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>Customer ID</th>
                                                        <th>Account Number</th>
                                                        <th>Type of Account</th>
                                                        <th>Actions</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="customer" items="${listCustomer}">
                                                            <tr>
                                                                <td><c:out value="${customer.customerId}"></c:out></td>
                                                                <td><c:out value="${customer.accountNumber}"></c:out></td>
                                                                <td><c:out value="${customer.accountType}"></c:out></td>
                                                                <td><a href="customer-details?customerId=<c:out value='${customer.customerId}' /> "><i class="fas fa-info-circle"></i>Details</a></td>
                                                                &nbsp;&nbsp;&nbsp;&nbsp;<a href="customer-delete?customerId=<c:out value='${customer.customerId}' /> "><i class="fas fa-trash-alt"></i>Delete</a>

                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
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