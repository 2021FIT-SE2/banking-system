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

    <title>Register</title>

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
<div class="container">
    <div class="row py-5 mt-4 align-items-center">
        <!-- For Demo Purpose -->
        <div class="col-md-5 pr-lg-5 mb-5 mb-md-0">
            <img src="https://res.cloudinary.com/mhmd/image/upload/v1569543678/form_d9sh6m.svg" alt=""
                 class="img-fluid mb-3 d-none d-md-block">
            <h1>Create an Account</h1>
            <p class="font-italic text-muted mb-0">Create an account to become our customer. We are there for you!</p>
            <p class="font-italic text-muted">Snippet By <a href="https://bootstrapious.com" class="text-muted">
                <u>CodersBank</u></a>
            </p>
        </div>

        <!-- Registeration Form -->
        <div class="col-md-7 col-lg-6 ml-auto">
            <form:form action="#" method="post" modelAttribute="registerDTO">

                <form:hidden path="token" />

                <div class="row">
                    <!-- First Name -->
                    <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
                        </div>
                        <form:input path="createCustomerDTO.firstName" id="firstName" type="text" name="firstname" placeholder="First Name"
                               class="form-control bg-white border-left-0 border-md" />
                        <form:errors path="createCustomerDTO.firstName" cssClass="text-warning" />
                    </div>

                    <!-- Last Name -->
                    <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
                        </div>
                        <form:input path="createCustomerDTO.lastName" id="lastName" type="text" name="lastname" placeholder="Last Name"
                               class="form-control bg-white border-left-0 border-md"/>
                    </div>

                    <!-- Email Address -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-envelope text-muted"></i>
                            </span>
                        </div>
                        <form:input path="createCustomerDTO.email" id="email" type="email" name="email" placeholder="Email Address"
                               class="form-control bg-white border-left-0 border-md"/>
                    </div>

                    <!-- Phone Number -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-phone-square text-muted"></i>
                            </span>
                        </div>
                        <form:select path="createCustomerDTO" id="countryCode" name="countryCode" style="max-width: 80px"
                                class="custom-select form-control bg-white border-left-0 border-md h-100 font-weight-bold text-muted">
                            <option value="">+84</option>
                        </form:select>
                        <form:input path="createCustomerDTO.phoneNumber" id="phoneNumber" type="tel" name="phone" placeholder="Phone Number"
                               class="form-control bg-white border-md border-left-0 pl-3" />
                    </div>

                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-envelope text-muted"></i>
                            </span>
                        </div>
                        <form:input path="createCustomerDTO.address" id="address" type="text" name="text" placeholder="Address"
                               class="form-control bg-white border-left-0 border-md" />
                    </div>

                    <!-- Gender -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-black-tie text-muted"></i>
                            </span>
                        </div>
                        <form:select path="createCustomerDTO.gender" id="gender" name="gender"
                                class="form-control custom-select bg-white border-left-0 border-md">
                            <option value="">Choose your Gender</option>
                            <option value="">Male</option>
                            <option value="">Female</option>
                        </form:select>
                    </div>

                    <!-- Password -->
                    <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <form:input path="createCustomerDTO.password" id="password" type="password" name="password" placeholder="Password"
                               class="form-control bg-white border-left-0 border-md" />
                    </div>

                    <!-- Password Confirmation -->
                    <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <label for="passwordConfirmation"></label>
                        <input id="passwordConfirmation" type="text" name="passwordConfirmation"
                                                                         placeholder="Confirm Password" class="form-control bg-white border-left-0 border-md">
                    </div>

                    <!-- Submit Button -->
                    <div class="form-group col-lg-12 mx-auto mb-0">
                        <a href="#" class="btn btn-primary btn-block py-2">
                            <span class="font-weight-bold">Create your account</span>
                        </a>
                    </div>

                    <!-- Already Registered -->
                    <div class="text-center w-100 mt-2">
                        <p class="text-muted font-weight-bold">Already Registered? <a href="<c:url value="/login"/>"
                                                                                      class="text-primary ml-2">Login</a>
                        </p>
                    </div>

                </div>
            </form:form>
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
