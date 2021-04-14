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
                                        <h3 class="m-b-10">Edit A Customer</h3>
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
                                                            <input type="number" name="customerId" class="form-control"
                                                                   value="<c:out value='${customer.customerId}' />">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Customer ID</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="fullName" class="form-control"
                                                                   value="<c:out value='${customer.fullName}'/>">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Full Name</label>
                                                        </div>
                                                        <div class="form-group form-default form-static-label">
                                                            <input type="date" name="dob"
                                                                   class="form-control"
                                                                   value="<c:out value='${customer.dob}'/>">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Date Of Birth</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <label class="col-sm-4 col-form-label">Gender</label>
                                                            <div class="col-sm-12">
                                                                <select name="select" class="form-control"
                                                                        name="gender">
                                                                    <option value="male">Male</option>
                                                                    <option value="female">Female</option>
                                                                    <option value="others">Others</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="address" class="form-control"
                                                                   value="<c:out value='${customer.address}'/>">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Address</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="phoneNumber" class="form-control"
                                                                   value="<c:out value='${customer.phoneNumber}' />">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Phone Number</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="text" name="accountNumber" class="form-control"
                                                                   value="<c:out value='${customer.accountNumber}' />">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Account Number</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <label class="col-sm-4 col-form-label">Type of
                                                                Account</label>
                                                            <div class="col-sm-12">
                                                                <select name="select" class="form-control"
                                                                        name="accountType">
                                                                    <option value="male">Normal Account</option>
                                                                    <option value="female">Saving Account</option>
                                                                    <option value="others">Loan Account</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="button">
                                                            <button type="submit" class="btn btn-primary">Save</button>
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