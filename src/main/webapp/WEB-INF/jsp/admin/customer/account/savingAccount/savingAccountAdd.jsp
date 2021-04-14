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
        <jsp:include page="../../../common-navbar.jsp"></jsp:include>

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <jsp:include page="../../../common-sidebar.jsp"></jsp:include>
                <div class="pcoded-content">
                    <!-- Page-header start -->
                    <div class="page-header">
                        <div class="page-block">
                            <div class="row align-items-center">
                                <div class="col-md-8">
                                    <div class="page-header-title">
                                        <h3 class="m-b-10">Add A New Saving Account</h3>
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
                                                    <h5>Add a new saving account</h5>
                                                    <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
                                                </div>
                                                <div class="card-block">
                                                    <form class="form-material">
                                                        <div class="form-group form-default">
                                                            <input type="number" name="customerId" class="form-control"
                                                                   disabled>
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Customer ID</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="number" name="rate" class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Rate</label>
                                                        </div>
                                                        <div class="form-group form-default form-static-label">
                                                            <input type="number" name="duration"
                                                                   class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Duration</label>
                                                        </div>
                                                        <div class="form-group form-default form-static-label">
                                                            <input type="date" name="startDate"
                                                                   class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Start Date</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="endDate" name="endDate" class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">End Date</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="number" name="principal" class="form-control">
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Principal</label>
                                                        </div>
                                                        <div class="form-group form-default">
                                                            <input type="number" name="interest" class="form-control"
                                                            >
                                                            <span class="form-bar"></span>
                                                            <label class="float-label">Interest</label>
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