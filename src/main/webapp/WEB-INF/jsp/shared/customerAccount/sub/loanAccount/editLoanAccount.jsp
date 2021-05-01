<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/prefix.jsp">

    <jsp:param name="title" value="Edit loan account"/>

    <jsp:param name="parentLink" value="Manage loan account"/>
    <jsp:param name="parentLinkUrl" value=""/>

    <jsp:param name="childLink" value="Edit loan account"/>
    <jsp:param name="childLinkUrl" value=""/>

    <jsp:param name="activeSidebarElementID" value="edit-loanAccounts"/>
</jsp:include>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Edit loan account</h5>
            </div>
            <div class="card-block">
                <form:form method="post" modelAttribute="updateLoanAccountDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <label class="col-sm-3 col-form-label" for="customerID">Customer ID</label>
                        <div class="col-sm-9">
                            <input id="customerID" type="number" class="form-control"
                                        required="required" value="${loanAccount.customer.id}"/>
                            <span class="form-bar"></span>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="principal">Principal</form:label>
                        <div class="col-sm-9">
                            <form:input path="principal" type="number" class="form-control"
                                        required="required" value="${loanAccount.principal}"/>
                            <span class="form-bar"></span>
                            <form:errors path="principal" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="startDate">Start Date</form:label>
                        <div class="col-sm-9"><form:input path="startDate" type="date" class="form-control"
                                                          required="required" value="${loanAccount.startDate}"/>
                            <span class="form-bar"></span>
                            <form:errors path="startDate" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <br><br>
                    <div class="d-flex justify-content-md-center">
                        <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal" data-target="#modalSave">Save</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/commons/admin/save-confirm.jsp"/>

<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/suffix.jsp"/>