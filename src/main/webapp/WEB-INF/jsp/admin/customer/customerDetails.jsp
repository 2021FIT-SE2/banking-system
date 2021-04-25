<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Customer Details"/>

    <jsp:param name="parentLinkText" value="Manage Customer"/>
    <jsp:param name="parentLinkUrl" value="/admin/customers"/>

    <jsp:param name="childLinkText" value="Customer Details"/>
    <jsp:param name="childLinkUrl" value="/admin/customers/1/details"/>

    <jsp:param name="activeSidebarElementID" value="add-customer"/>
</jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/customerDetails.css"/>">

<!-- START HERE -->
<div class="container">
    <div class="row gutters">
        <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <div class="card-body">
                    <div class="account-settings">
                        <div class="user-profile">
                            <div class="user-avatar">
                                <img src="<c:url value="resources/img/profile.png"/>" alt="Maxwell Admin">
                            </div>
                            <h5 class="user-name">${customer.firstName} ${customer.lastName}</h5>
                            <h6 class="user-phone-number">${customer.phoneNumber}</h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <form:form action="" method="post" modelAttribute="customer">
                    <div class="card-body">
                        <div class="row gutters" style="margin-bottom: 10px">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <h6 class="mb-2 text-primary">Personal Details</h6>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="username">Username</form:label>
                                    <form:input type="text" class="form-control" path="username"
                                                placeholder="Enter Username" value="${customer.username}"/>
                                </fieldset>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="password">Password</form:label>
                                    <form:input type="password" class="form-control" path="password"
                                                placeholder="Enter Password" value="${customer.password}"/>
                                </fieldset>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="id">ID</form:label>
                                    <form:input disabled="true" type="text" class="form-control" path="id"
                                                placeholder="ID" value="${customer.id}"/>
                                </fieldset>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="createdAt">Created At</form:label>
                                    <form:input disabled="true" type="text" class="form-control" path="createdAt"
                                                placeholder="Enter Password" value="${customer.createdAt.toString()}"/>
                                </fieldset>
                            </div>
                        </div>

                        <div class="row gutters">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <h6 class="mb-2 text-primary">Personal Details</h6>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="firstName">First Name</form:label>
                                    <form:input type="text" class="form-control" path="firstName"
                                                placeholder="Enter first name" value="${customer.firstName}"/>
                                </fieldset>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="lastName">Last Name</form:label>
                                    <form:input type="text" class="form-control" path="lastName"
                                                placeholder="Enter last name" value="${customer.lastName}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="gender">Gender</form:label>
                                    <form:select path="gender" type="text" class="form-control form-select"
                                                 required="required" value="${customer.gender}">
                                        <form:option value="MALE" label="Male"/>
                                        <form:option value="FEMALE" label="Female"/>
                                    </form:select>
                                </fieldset>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="dob">Date Of Birth</form:label>
                                    <form:input type="date" class="form-control" path="dob"
                                                placeholder="Select Date Of Birth" value="${customer.dob}"/>
                                </fieldset>
                            </div>
                        </div>

                        <div class="row gutters">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <h6 class="mt-3 mb-2 text-primary">Contact</h6>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="phoneNumber">Phone Number</form:label>
                                    <form:input type="text" class="form-control" path="phoneNumber"
                                                placeholder="Enter phone number" value="${customer.phoneNumber}"/>
                                </fieldset>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="email">Email</form:label>
                                    <form:input type="email" class="form-control" path="email" placeholder="Enter Email"
                                                value="${customer.email}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <fieldset class="form-group">
                                    <form:label path="address">Address</form:label>
                                    <form:input type="address" class="form-control" path="address" placeholder="Enter Address"
                                                value="${customer.address}"/>
                                </fieldset>
                            </div>

                        </div>
                        <div class="row gutters">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="text-right">
                                    <button type="button" name="submit" class="btn btn-secondary">Cancel</button>
                                    <button type="button" id="submit" name="submit" class="btn btn-primary">Update
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

    <div class="card" style="margin-top: 20px">
        <div class="card-header">
            <h5>Customer Account</h5>
            <div class="card-header-right" style="margin-right: 10px">
                <a href="<c:url value="/admin/customerAccounts/create"/>">
                    <button type="submit" class="btn btn-primary">Create New</button>
                </a>
            </div>
        </div>
        <div class="card-block table-border-style">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Type</th>
                        <th>Created At</th>
                        <th>Updated At</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customerAccount" items="${customerAccountList}">
                        <tr>
                            <td>
                                <a href="/admin/customerAccounts/${customerAccount.id}">${customerAccount.id}</a>
                            </td>
                            <td>${customerAccount.accountType}</td>

                            <fmt:parseDate value="${customerAccount.createdAt}" pattern="yyyy-MM-dd" var="createdAt" type="date"/>
                            <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy" /></td>

                            <fmt:parseDate value="${customerAccount.updatedAt}" pattern="yyyy-MM-dd" var="updatedAt" type="date"/>
                            <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy" /></td>

                            <td>
                                <a href="/admin/customerAccounts/${customerAccount.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>
                                <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal" data-target="#modalDelete"></i></a>
                            </td>
                        </tr>
                        <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Are you sure to delete?</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-footer d-flex justify-content-md-center">
                                        <a href="/admin/customers/${customerAccount.id}/delete"><button type="submit" id="btn-yes" class="btn btn-primary">Yes</button></a>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>