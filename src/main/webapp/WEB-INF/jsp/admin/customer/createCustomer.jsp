<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Create Customer" />

    <jsp:param name="parentLink" value="Manage Customer" />
    <jsp:param name="parentLinkUrl" value="" />

    <jsp:param name="childLink" value="Create New" />
    <jsp:param name="childLinkUrl" value="" />

    <jsp:param name="activeSidebarElementID" value="add-customer" />
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
                        <form:label cssClass="col-sm-2 col-form-label" path="username">Username</form:label>
                        <div class="col-sm-10">
                            <form:input path="username" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="username" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="password">Password</form:label>
                        <div class="col-sm-10">
                            <form:input path="password" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="password" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="email">Email</form:label>
                        <div class="col-sm-10">
                            <form:input path="email" type="email" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="email" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="phoneNumber">Phone Number</form:label>
                        <div class="col-sm-10"><form:input path="phoneNumber" type="text" class="form-control"
                                                           required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="phoneNumber" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="firstName">First Name</form:label>
                        <div class="col-sm-10">
                            <form:input path="firstName" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="firstName" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="lastName">Last Name</form:label>
                        <div class="col-sm-10">
                            <form:input path="lastName" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="lastName" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="gender">Gender</form:label>

                        <div class="col-sm-10"><form:select path="gender" type="text" class="form-control form-select"
                                                            required="required">
                            <form:option value="MALE" label="Male"/>
                            <form:option value="FEMALE" label="Female"/>
                        </form:select>
                            <span class="form-bar"></span>
                            <form:errors path="gender" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="dob">Date Of Birth</form:label>
                        <div class="col-sm-10"><form:input path="dob" type="date" class="form-control"
                                                           required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="dob" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-2 col-form-label" path="address">Address</form:label>
                        <div class="col-sm-10"><form:input path="address" type="text" class="form-control"
                                                           required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="address" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>