<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/prefix.jsp">

    <jsp:param name="title" value="Create Charge Transaction"/>

    <jsp:param name="parentLinkText" value="Manage Charge Transactions" />
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions" />

    <jsp:param name="childLinkText" value="Create" />
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions/create" />

    <jsp:param name="activeSidebarElementID" value="add-chargeTransaction"/>
</jsp:include>

    <div class="row justify-content-center align-items-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h5>Add a new charge transaction</h5>
                    <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
                </div>
                <div class="card-block">
                    <%--@elvariable id="createChargeTransactionDTO" type="com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.dto.CreateChargeTransactionDTO"--%>
                    <form:form method="post" modelAttribute="createChargeTransactionDTO" cssClass="form-material">
                        <fieldset class="form-group row row">
                            <form:label cssClass="col-sm-3 col-form-label" path="customerAccountID">Account ID</form:label>
                            <div class="col-sm-9">
                                <form:input path="customerAccountID" type="text" class="form-control"
                                            required="required"/>
                                <span class="form-bar"></span>
                                <form:errors path="customerAccountID" cssClass="text-warning"/>
                            </div>
                        </fieldset>

                        <fieldset class="form-group row">
                            <form:label cssClass="col-sm-3 col-form-label" path="redeemAmount">Redeem Amount</form:label>
                            <div class="col-sm-9">
                                <form:input path="redeemAmount" type="number" class="form-control"
                                            required="required"/>
                                <span class="form-bar"></span>
                                <form:errors cssClass="text-warning"/>
                            </div>
                        </fieldset>
                        <br><br>
                        <div class="d-flex justify-content-md-center">
                            <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal" data-target="#modalAdd">Add</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="btn-reset" type="button" class="btn btn-danger">Reset</button>
                        </div>
                    </form:form>


                </div>
            </div>
        </div>
    </div>
<jsp:include page="/WEB-INF/commons/admin/add-confirm.jsp"/>

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/suffix.jsp"/>
