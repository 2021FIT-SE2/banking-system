<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Create Transfer Transaction"/>

    <jsp:param name="parentLinkText" value="Manage Transfer Transactions"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transferTransactions"/>

    <jsp:param name="childLinkText" value="Create"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transferTransactions/create"/>

    <jsp:param name="activeSidebarElementID" value="add-transferTransaction"/>
</jsp:include>

<div class="row justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <%--@elvariable id="error" type="String"--%>
            <c:if test="${error != null}">
                <div class="alert alert-danger" role="alert" style="margin-bottom: 20px">
                    <h4 class="alert-heading">Error</h4>
                    <p>${error}</p>
                </div>
            </c:if>
            <div class="card-header">
                <h5>Add a new transfer transaction</h5>
                <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
            </div>
            <div class="card-block">
                <%--@elvariable id="createTransferTransactionDTO" type="com.se2.bankingsystem.domains.Transaction.sub.TransferTransaction.dto.CreateTransferTransactionDTO"--%>

                <form:form method="post" modelAttribute="createTransferTransactionDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="customerAccountID">Account ID</form:label>
                        <div class="col-sm-9">
                            <c:choose>
                                <c:when test="${authority == 'ADMIN'}">
                                    <form:input path="customerAccountID" type="text" class="form-control"
                                                required="required"/>
                                </c:when>

                                <c:when test="${authority == 'CUSTOMER'}">
                                    <form:select class="form-control" path="customerAccountID">
                                        <option value="" disabled selected hidden class="text-secondary">Select an
                                            Account to transfer from
                                        </option>
                                        <%--@elvariable id="customerAccountList" type="java.util.List"--%>
                                        <c:forEach var="customerAccount" items="${customerAccountList}">
                                            <%--@elvariable id="customerAccount" type="com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount"--%>
                                            <form:option value="${customerAccount.id}">
                                                ID: ${customerAccount.id} - ${customerAccount.accountType} ACCOUNT
                                            </form:option>
                                        </c:forEach>
                                    </form:select>
                                </c:when>

                                <c:otherwise>
                                    Internal Error
                                </c:otherwise>

                            </c:choose>
                            <span class="form-bar"></span>
                            <form:errors path="customerAccountID" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="receiverID">Receiver ID</form:label>
                        <div class="col-sm-9">
                            <form:input path="receiverID" type="text" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="receiverID" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label"
                                    path="transferAmount">Transfer Amount</form:label>
                        <div class="col-sm-9">
                            <form:input path="transferAmount" type="number" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="transferAmount" cssClass="text-warning"/>
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
                        <jsp:param name="message" value="Confirm updating this Saving Account?"/>
                    </jsp:include>
                </form:form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="${commonPrefix}/success-dialog.jsp"/>
<jsp:include page="${commonPrefix}/suffix.jsp"/>
