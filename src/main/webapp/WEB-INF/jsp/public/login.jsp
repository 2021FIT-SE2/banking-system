<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign In Template for Bootstrap</title>

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
                            <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur
                                adipisicing.</p>
                        </div>
                        <form action="#" method="POST">
                            <div class="form-group first">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username">

                            </div>
                            <div class="form-group last mb-4">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password">
                            </div>

                            <div class="d-flex mb-5 align-items-center">
                                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                                    <input type="checkbox" checked="checked"/>
                                    <div class="control__indicator"></div>
                                </label>
                                <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span>
                            </div>

                            <input type="submit" value="Log In" class="btn btn-block btn-primary">
                        </form>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>

<div id="recaptcha-container"></div>

<script src="<c:url value="/webjars/jquery/3.6.0/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.slicknav.js"/>"></script>
<script src="<c:url value="/resources/js/lib/owl.carousel.min.js"/>"></script>

<!-- Insert these scripts at the bottom of the HTML, but before you use any Firebase services -->

<!-- Firebase App (the core Firebase SDK) is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/8.3.1/firebase-app.js"></script>

<!-- If you enabled Analytics in your project, add the Firebase SDK for Analytics -->
<script src="https://www.gstatic.com/firebasejs/8.3.1/firebase-analytics.js"></script>

<!-- Add Firebase products that you want to use -->
<script src="https://www.gstatic.com/firebasejs/8.3.1/firebase-auth.js"></script>
<script>
    // Your web app's Firebase configuration
    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
    let firebaseConfig = {
        apiKey: "AIzaSyAOzsdYRws3Eys46tdxupmiStMs3Tv_ckI",
        authDomain: "cute-banking-system.firebaseapp.com",
        projectId: "cute-banking-system",
        storageBucket: "cute-banking-system.appspot.com",
        messagingSenderId: "909023602643",
        appId: "1:909023602643:web:6b78fb3aedfea87df9f126",
        measurementId: "G-3GBL12T1CB"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
</script>

<script src="<c:url value="/resources/js/login.js"/>"></script>
</body>
</html>
