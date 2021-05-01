<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome.min.css"/>">
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
        </div>

        <!-- RegisterForm -->
        <div class="col-md-7 col-lg-6 ml-auto">
            <form:form method="post" modelAttribute="createCustomerDTO">

                <div class="row">
                    <!-- First Name -->
                    <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="firstName">
                            <form:input required="true" path="firstName" id="firstName" type="text" name="firstName"
                                        placeholder="First Name"
                                        class="form-control bg-white border-left-1 border-md${status.error ? ' is-invalid' : ''}"/>
                            <form:errors path="firstName" cssClass="invalid-feedback"/>
                        </spring:bind>
                    </div>

                    <!-- Last Name -->
                    <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="lastName">
                            <form:input required="true" path="lastName" id="lastName" type="text" name="lastName"
                                        placeholder="Last Name"
                                        class="form-control bg-white border-left-1 border-md${status.error ? ' is-invalid' : ''}"/>
                            <form:errors path="lastName" cssClass="invalid-feedback"/>
                        </spring:bind>
                    </div>

                    <!-- Email Address -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-envelope text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="email">
                            <form:input required="true" path="email" id="email" type="email" name="email"
                                        placeholder="Email Address"
                                        class="form-control bg-white border-left-1 border-md${status.error ? ' is-invalid' : ''}"/>
                            <form:errors path="email" cssClass="invalid-feedback"/>
                        </spring:bind>
                    </div>

                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="username">
                            <form:input required="true" path="username" id="username" type="text" name="username"
                                        placeholder="Username"
                                        class="form-control bg-white border-left-1 border-md${status.error ? ' is-invalid' : ''}"/>
                            <form:errors path="username" cssClass="invalid-feedback"/>
                        </spring:bind>
                    </div>

                    <!-- Phone Number -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-right-0">
                                <i class="fa fa-phone-square text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="phoneNumber">
                            <form:input required="true" path="phoneNumber" id="phoneNumber" type="tel" name="phone"
                                        placeholder="Phone Number"
                                        class="form-control bg-white border-md border-left-1${status.error ? ' is-invalid' : ''}"/>
                            <form:errors path="phoneNumber" cssClass="invalid-feedback"/>
                        </spring:bind>
                    </div>

                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-map-marker text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="address">
                            <form:input required="true" path="address" id="address" type="text" name="text"
                                        placeholder="Address"
                                        class="form-control bg-white border-left-1 border-md${status.error ? ' is-invalid' : ''}"/>
                            <form:errors path="address" cssClass="invalid-feedback"/>
                        </spring:bind>
                    </div>

                    <!-- Gender -->
                    <div class="input-group col-lg-12 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-black-tie text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="gender">
                            <form:select path="gender" id="gender" name="gender"
                                         class="form-control custom-select bg-white border-left-1 border-md ${status.error ? ' is-invalid' : ''}"
                                         placeholder="Choose your Gender" required="true">
                                <form:option value="MALE">Male</form:option>
                                <form:option value="FEMALE">Female</form:option>
                            </form:select>
                        </spring:bind>
                    </div>

                    <!-- Password -->
                    <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <spring:bind path="password">
                            <form:input required="true" path="password" id="password" type="password" name="password"
                                        placeholder="Password"
                                        class="form-control bg-white border-left-1 border-md${status.error ? ' is-invalid' : ''}"/>
                            <form:errors path="password" cssClass="invalid-feedback"/>
                        </spring:bind>
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
                               placeholder="Confirm Password" class="form-control bg-white border-left-1 border-md">
                    </div>

                    <!-- Submit Button -->
                    <div class="form-group col-lg-12 mx-auto mb-0">
                        <button type="submit" class="btn btn-primary btn-block py-2">
                            <span>Create your account</span>
                        </button>
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

<div class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%--<script src="<c:url value="/webjars/jquery/3.6.0/jquery.min.js"/>"></script>--%>
<%--<script src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"/>"></script>--%>
</body>
</html>
