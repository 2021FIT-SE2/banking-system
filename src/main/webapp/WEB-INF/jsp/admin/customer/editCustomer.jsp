<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/prefix.jsp">

    <jsp:param name="title" value="Create Customer" />

    <jsp:param name="parentLinkText" value="Manage Customer" />
    <jsp:param name="parentLinkUrl" value="/admin/customers" />

    <jsp:param name="childLinkText" value="Create New" />
    <jsp:param name="childLinkUrl" value="/admin/customers/1/edit" />

    <jsp:param name="activeSidebarElementID" value="add-customer" />
</jsp:include>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Edit Customer </h5>
            </div>
            <div class="card-block">
                <form:form method="post" modelAttribute="updateCustomerDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <label class="col-sm-3 col-form-label" for="username">Username</label>
                        <div class="col-sm-9">
                            <input disabled id="username" type="text" class="form-control"
                                   required="required" value="${customer.username}"/>
                            <span class="form-bar"></span>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="email">Email</form:label>
                        <div class="col-sm-9">
                            <form:input path="email" type="email" class="form-control"
                                        required="required" value="${customer.email}"/>
                            <span class="form-bar"></span>
                            <form:errors path="email" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <label class="col-sm-3 col-form-label" for="phoneNumber">Phone Number</label>
                        <div class="col-sm-9">
                            <input disabled id="phoneNumber" type="text" class="form-control"
                                   required="required" value="${customer.phoneNumber}"/>
                            <span class="form-bar"></span>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="firstName">First Name</form:label>
                        <div class="col-sm-9">
                            <form:input path="firstName" type="text" class="form-control"
                                        required="required" value="${customer.firstName}"/>
                            <span class="form-bar"></span>
                            <form:errors path="firstName" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="lastName">Last Name</form:label>
                        <div class="col-sm-9">
                            <form:input path="lastName" type="text" class="form-control"
                                        required="required" value="${customer.lastName}"/>
                            <span class="form-bar"></span>
                            <form:errors path="lastName" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="gender">Gender</form:label>

                        <div class="col-sm-9"><form:select path="gender" type="text" class="form-control form-select"
                                                            required="required" value="${customer.gender}">
                            <form:option value="MALE" label="Male"/>
                            <form:option value="FEMALE" label="Female"/>
                        </form:select>
                            <span class="form-bar"></span>
                            <form:errors path="gender" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="dob">Date Of Birth</form:label>
                        <div class="col-sm-9"><form:input path="dob" type="date" class="form-control"
                                                           required="required" value="${customer.dob}"/>
                            <span class="form-bar"></span>
                            <form:errors path="dob" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="address">Address</form:label>
                        <div class="col-sm-9"><form:input path="address" type="text" class="form-control"
                                                           required="required" value="${customer.address}"/>
                            <span class="form-bar"></span>
                            <form:errors path="address" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <div class="col-md-8 offset-md-5">
                        <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal" data-target="#modalSave">Save</button>&nbsp;
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/commons/admin/save-confirm.jsp"/>

<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/suffix.jsp"/>