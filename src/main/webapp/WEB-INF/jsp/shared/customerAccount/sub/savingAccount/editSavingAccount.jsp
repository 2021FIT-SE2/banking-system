<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Create saving account"/>

    <jsp:param name="parentLink" value="Manage saving account"/>
    <jsp:param name="parentLinkUrl" value=""/>

    <jsp:param name="childLink" value="Create New saving account"/>
    <jsp:param name="childLinkUrl" value=""/>

    <jsp:param name="activeSidebarElementID" value="add-savingAccounts"/>
</jsp:include>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Add a new saving account</h5>
            </div>
            <div class="card-block">
                <form:form method="post" modelAttribute="updateSavingAccountDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="customerID">Customer ID</form:label>
                        <div class="col-sm-9">
                            <form:input path="customerID" type="number" class="form-control"
                                        required="required" value="${savingAccount.customerID}"/>
                            <span class="form-bar"></span>
                            <form:errors path="customerID" cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="balance">Balance</form:label>
                        <div class="col-sm-9">
                            <form:input path="balance" type="number" class="form-control"
                                        required="required" value="${savingAccount.balance}"/>
                            <span class="form-bar"></span>
                            <form:errors path="balance" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="principal">Principal</form:label>
                        <div class="col-sm-9">
                            <form:input path="principal" type="number" class="form-control"
                                        required="required" value="${savingAccount.principal}"/>
                            <span class="form-bar"></span>
                            <form:errors path="principal" cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="interest">Interest</form:label>
                        <div class="col-sm-9">
                            <form:input path="interest" type="text" class="form-control"
                                        required="required" value="${savingAccount.interest}"/>
                            <span class="form-bar"></span>
                            <form:errors path="interest" cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="rate">Rate</form:label>
                        <div class="col-sm-9">
                            <form:input path="rate" type="number" class="form-control"
                                        required="required" value="${savingAccount.rate}"/>
                            <span class="form-bar"></span>
                            <form:errors path="rate" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="duration">Duration</form:label>
                        <div class="col-sm-9">
                            <form:input path="duration" type="number" class="form-control"
                                        required="required" value="${savingAccount.savingDuration}"/>
                            <span class="form-bar"></span>
                            <form:errors path="duration" cssClass="text-warning"/>
                        </div>

                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="startDate">Start Date</form:label>
                        <div class="col-sm-9"><form:input path="startDate" type="date" class="form-control"
                                                          required="required" value="${savingAccount.startDate}"/>
                            <span class="form-bar"></span>
                            <form:errors path="startDate" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="endDate">End Date</form:label>
                        <div class="col-sm-9">
                            <form:input path="endDate" type="date" class="form-control"
                                        required="required" value="${savingAccount.endDate}"/>
                            <span class="form-bar"></span>
                            <form:errors path="endDate" cssClass="text-warning"/>
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
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>