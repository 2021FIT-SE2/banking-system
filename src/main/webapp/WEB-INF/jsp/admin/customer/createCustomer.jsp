<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Create Customer"/>

    <jsp:param name="parentLinkText" value="Manage Customer"/>
    <jsp:param name="parentLinkUrl" value="/admin/customers"/>

    <jsp:param name="childLinkText" value="Create New"/>
    <jsp:param name="childLinkUrl" value="/admin/customers/create"/>

    <jsp:param name="activeSidebarElementID" value="customer-create"/>
</jsp:include>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Add a new customer</h5>
            </div>
            <div class="card-block">
                <form:form method="post" modelAttribute="createCustomerDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="username">Username</form:label>
                        <div class="col-sm-9">
                            <form:input path="username" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="username" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="password">Password</form:label>
                        <div class="col-sm-9">
                            <form:input path="password" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="password" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="email">Email</form:label>
                        <div class="col-sm-9">
                            <form:input path="email" type="email" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="email" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="phoneNumber">Phone Number</form:label>
                        <div class="col-sm-9"><form:input path="phoneNumber" type="text" class="form-control"
                                                          required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="phoneNumber" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="firstName">First Name</form:label>
                        <div class="col-sm-9">
                            <form:input path="firstName" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="firstName" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="lastName">Last Name</form:label>
                        <div class="col-sm-9">
                            <form:input path="lastName" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="lastName" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="gender">Gender</form:label>

                        <div class="col-sm-9">
                            <form:select path="gender" type="text" class="form-control form-select"
                                         required="required">
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
                                                          required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="dob" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="address">Address</form:label>
                        <div class="col-sm-9"><form:input path="address" type="text" class="form-control"
                                                          required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="address" cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <br><br>
                    <div class="d-flex justify-content-md-center">
                        <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal"
                                data-target="#modalConfirm">Add
                        </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button id="btn-reset" type="button" class="btn btn-danger">Reset</button>
                    </div>

                    <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                        <jsp:param name="message" value="Confirm adding this Customer?"/>
                    </jsp:include>
                </form:form>
            </div>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>