<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <p class="mb-4 mt-1">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur
                                adipisicing.</p>
                        </div>

                        <div class="form-group last mb-4">
                            <label for="phone-number-input">Phone Number</label>
                            <input type="text" class="form-control" id="phone-number-input">
                        </div>

                        <div class="form-group last mb-4" id="verification-code-container"
                             style="display: none !important;">
                            <label for="verification-code-input">Verification Code</label>
                            <input type="text" class="form-control" id="verification-code-input">
                        </div>

                        <div class="d-flex mb-5 align-items-center">
                            <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                                <input id="remember-me" type="checkbox" checked="checked"/>
                                <div class="control__indicator"></div>
                            </label>
                            <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span>
                        </div>

                        <button id="send-sms-code-button" type="submit" class="btn btn-block btn-primary">Send SMS
                            Code
                        </button>

                        <form:form id="sign-in-form" method="post" modelAttribute="loginRequestDTO">
                            
                            <form:input id="token" type="hidden" path="token" name="token" value="" />
                            
                            <button id="verify-sms-code-button" type="submit" class="btn btn-block btn-primary"
                                    style="display: none !important;">Sign In
                            </button>
                        </form:form>
                        <p class="mb-4 mt-1">Don't have an account? <a href="<c:url value="/register"/>">Sign Up</a></p>

                        <div style="margin-top: 20px" id="recaptcha-container"></div>
                        <%--                        </form>--%>
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
