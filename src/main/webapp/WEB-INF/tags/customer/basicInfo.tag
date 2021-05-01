<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="customer" required="true" type="com.se2.bankingsystem.domains.Customer.entity.Customer" %>
<%@ taglib prefix="customer" tagdir="/WEB-INF/tags/customer"%>

<div class="row gutters">
    <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12 d-flex">
        <div class="card w-100">
            <div class="card-body">
                <div class="account-settings">
                    <div class="user-profile">
                        <div class="user-avatar">
                            <img src="<c:url value="resources/img/profile.png"/>" alt="Normal Account Icon">
                        </div>
                        <h5 class="user-name">${customer.firstName} ${customer.lastName}</h5>
                        <h6 class="user-phone-number">Owner</h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
        <div class="card">
            <div class="card-body">
                <div class="row gutters" style="margin-bottom: 10px">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <h6 class="mb-2 text-primary">Account Owner Details</h6>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-username">Username</label>
                            <input type="text" class="form-control" id="customer-username"
                                   placeholder="Enter Username" value="${customer.username}"/>
                        </fieldset>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-password">Password</label>
                            <input type="password" class="form-control" id="customer-password"
                                   placeholder="Enter Password" value="${customer.password}"/>
                        </fieldset>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-id">ID</label>
                            <input disabled type="text" class="form-control" id="customer-id"
                                   placeholder="ID" value="${customer.id}"/>
                        </fieldset>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-createdAt">Created At</label>

                            <fmt:parseDate value="${customer.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedCreatedAt" type="both"/>
                            <fmt:formatDate var="createdAt" value="${parsedCreatedAt}" pattern="HH:mm dd/MM/yyyy" />

                            <input disabled type="text" class="form-control" id="customer-createdAt"
                                   placeholder="Enter Password"
                                   value="${createdAt}"/>
                        </fieldset>
                    </div>
                </div>

                <div class="row gutters">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <h6 class="mb-2 text-primary">Personal Details</h6>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-firstName">First Name</label>
                            <input type="text" class="form-control" id="customer-firstName"
                                   value="${customer.firstName}"/>
                        </fieldset>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-lastName">Last Name</label>
                            <input type="text" class="form-control" id="customer-lastName"
                                   value="${customer.lastName}"/>
                        </fieldset>
                    </div>

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-gender">Gender</label>
                            <input disabled id="customer-gender" type="text" class="form-control form-select"
                                   value="${customer.gender}"/>

                        </fieldset>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-dob">Date Of Birth</label>
                            <input type="date" class="form-control" id="customer-dob"
                                   value="${customer.dob}"/>
                        </fieldset>
                    </div>
                </div>

                <div class="row gutters">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <h6 class="mt-3 mb-2 text-primary">Contact</h6>
                    </div>

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-phoneNumber">Phone Number</label>
                            <input type="text" class="form-control" id="customer-phoneNumber"
                                   value="${customer.phoneNumber}"/>
                        </fieldset>
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                        <fieldset class="form-group">
                            <label for="customer-email">Email</label>
                            <input type="email" class="form-control" id="customer-email"
                                   value="${customer.email}"/>
                        </fieldset>
                    </div>

                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <fieldset class="form-group">
                            <label for="customer-address">Address</label>
                            <input class="form-control" id="customer-address"
                                   value="${customer.address}"/>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>