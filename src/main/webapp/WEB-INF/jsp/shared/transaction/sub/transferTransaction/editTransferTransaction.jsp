<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Create Transfer Transaction"/>

    <jsp:param name="parentLink" value="Manage Transfer Transaction"/>
    <jsp:param name="parentLinkUrl" value=""/>

    <jsp:param name="childLink" value="Create New Transfer Transaction"/>
    <jsp:param name="childLinkUrl" value=""/>

    <jsp:param name="activeSidebarElementID" value="add-transferTransaction"/>
</jsp:include>
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Add a new transfer transaction</h5>
                <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
            </div>
            <div class="card-block">
                <form:form method="post" modelAttribute="updateTransferTransactionDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="customerAccountID">Customer Account Id</form:label>
                        <div class="col-sm-9">
                            <form:input path="customerAccountID" type="number" class="form-control"
                                        required="required" value="${transferTransaction.customerAccount}"/>
                            <span class="form-bar"></span>
                            <form:errors path="customerAccountID" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="beneficialAccount">Beneficial Account</form:label>
                        <div class="col-sm-9">
                            <form:input path="beneficialAccount" type="text" class="form-control"
                                        required="required" value="${transferTransaction.beneficialAccount}"/>
                            <span class="form-bar"></span>
                            <form:errors cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="transferAmount">Transfer Amount</form:label>
                        <div class="col-sm-9">
                            <form:input path="transferAmount" type="number" class="form-control"
                                        required="required" value="${transferTransaction.transferAmount}"/>
                            <span class="form-bar"></span>
                            <form:errors cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="status">Status</form:label>

                        <div class="col-sm-9"><form:select path="status" type="text" class="form-control form-select"
                                                           required="required" value="${transferTransaction.status}">
                            <form:option value="PENDING" label="Pending"/>
                            <form:option value="COMPLETED" label="Completed"/>
                        </form:select>
                            <span class="form-bar"></span>
                            <form:errors path="status" cssClass="text-warning"/>
                        </div>

                    </fieldset>
                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="createdAt">Created At</form:label>
                        <div class="col-sm-9">
                            <form:input path="createdAt" type="date" class="form-control"
                                        required="required" value="${transferTransaction.createdAt}"/>
                            <span class="form-bar"></span>
                            <form:errors cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="updatedAt">Updated At</form:label>
                        <div class="col-sm-9">
                            <form:input path="updatedAt" type="date" class="form-control"
                                        required="required" value="${transferTransaction.updatedAt}"/>
                            <span class="form-bar"></span>
                            <form:errors cssClass="text-warning"/>
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

<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>