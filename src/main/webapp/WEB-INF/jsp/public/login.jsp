<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign In</title>

    <!-- Bootstrap core CSS -->
    <script src="<c:url value="/webjars/jquery/3.6.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css"/>"/>

    <!-- Extended CSS resources -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/elegant-icons.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/flaticon.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/owl.carousel.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/slicknav.min.css"/>">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">

    <!-- Custom styles for this page -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
</head>

<body>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="<c:url value="resources/img/login/undraw_remotely_2j6y.svg"/>" alt="Image" class="img-fluid"/>
            </div>
            <div class="col-md-6 contents">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="mb-4">
                            <h3>Sign In</h3>
                            <p class="mb-4 mt-1">Welcome back!</p>
                        </div>

                        <c:if test="${param.containsKey('error')}">
                            <p class="text-danger">Incorrect Username or Password</p>
                        </c:if>

                        <form:form method="post" modelAttribute="loginDTO">
                            <div class="form">
                                <form:label path="username">Username</form:label>
                                <form:input path="username" type="text" class="form-control" id="username"  />
                            </div>

                            <div class="form">
                                <form:label path="password">Password</form:label>
                                <form:input path="password" type="password" class="form-control" id="password" />
                            </div>
                            <br>
                            <button type="submit" class="btn btn-block btn-primary">Sign In</button>
                        </form:form>

                        <p class="mb-4 mt-1">Don't have an account? <a href="<c:url value="/register"/>">Sign Up</a></p>

                    </div>
                </div>

            </div>

        </div>
    </div>
</div>


<script src="<c:url value="/webjars/jquery/3.6.0/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.slicknav.js"/>"></script>
<script src="<c:url value="/resources/js/lib/owl.carousel.min.js"/>"></script>
</body>
</html>
