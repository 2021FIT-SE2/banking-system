<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/commons/admin/prefix.jsp"/>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Edit Charge Transaction </h5>
            </div>
            <div class="card-block">
                <form:form method="post" modelAttribute="updateChargeTransactionDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <form:label path="customerAccountId" class="col-sm-3 col-form-label" for="customerAccountId">Customer's account Id</form:label>
                        <div class="col-sm-9">
                            <form:input path="customerAccountID" type="text" class="form-control"
                                   required="required" value="${chargeTransaction.customerAccount}"/>
                            <span class="form-bar"></span>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="redeemAmount">Redeem Amount</form:label>
                        <div class="col-sm-9">
                            <form:input path="redeemAmount" type="email" class="form-control"
                                        required="required" value="${chargeTransaction.redeemAmount}"/>
                            <span class="form-bar"></span>
                            <form:errors path="redeemAmount" cssClass="text-warning"/>
                        </div>

                    </fieldset>
                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="createdAt">Created At</form:label>
                        <div class="col-sm-9">
                            <form:input path="createdAt" type="date" class="form-control"
                                        required="required" value="${chargeTransaction.createdAt}"/>
                            <span class="form-bar"></span>
                            <form:errors cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="updatedAt">Updated At</form:label>
                        <div class="col-sm-9">
                            <form:input path="updatedAt" type="date" class="form-control"
                                        required="required" value="${chargeTransaction.updatedAt}"/>
                            <span class="form-bar"></span>
                            <form:errors cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <div class="col-md-8 offset-md-5">
                        <button id="btn-save" type="submit" class="btn btn-success" data-toggle="modal" data-target="#modalSave">Save</button>&nbsp;
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/commons/admin/save-confirm.jsp"/>

<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>