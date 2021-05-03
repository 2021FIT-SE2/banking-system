<%--@elvariable id="savingAccount" type="com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Saving Account Details"/>

    <jsp:param name="parentLinkText" value="Manage Saving Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts"/>

    <jsp:param name="childLinkText" value="Details"/>
    <jsp:param name="childLinkUrl"
               value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/${savingAccount.id}"/>

    <jsp:param name="activeSidebarElementID" value="savingAccount-list"/>
</jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/customerDetails.css"/>">

<!-- START HERE -->
<div class="container">
    <div class="row gutters">
        <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12 d-flex">
            <div class="card w-100">
                <div class="card-body">
                    <div class="account-settings">
                        <div class="user-profile">
                            <div class="user-avatar">
                                <img src="<c:url value="resources/img/accountant.png"/>" alt="Saving Account Icon">
                            </div>
                            <h5 class="user-name">Saving Account</h5>
                            <h6 class="user-phone-number">${savingAccount.id}</h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card">
                <form:form action="" method="post" modelAttribute="savingAccount">
                    <div class="card-body">
                        <div class="row gutters" style="margin-bottom: 10px">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
                                <h6 class="mb-2 text-primary">Saving Account Details</h6>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
                                <div class="text-right">
                                    <c:if test="${authority == 'ADMIN'}">
                                        <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/${savingAccount.id}/edit"><i
                                                class="ti-pencil-alt fa-2x text-primary"></i></a>
                                        <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                              data-target="#modalConfirm"></i></a>
                                    </c:if>
                                </div>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <label for="id">ID</label>
                                    <input disabled type="text" class="form-control" id="id"
                                           value="${savingAccount.id}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="principal">Principal</form:label>
                                    <form:input type="text" class="form-control" path="principal"
                                                placeholder="Enter Balance" value="${savingAccount.principal}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="savingDuration">Saving Duration</form:label>
                                    <form:input type="text" class="form-control" path="savingDuration"
                                                placeholder="Enter Balance" value="${savingAccount.savingDuration}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="currentSaving">Current Saving</form:label>
                                    <form:input type="text" class="form-control" path="currentSaving"
                                                placeholder="Enter Balance" value="${savingAccount.currentSaving}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <label for="createdAt">Created At</label>

                                    <fmt:parseDate value="${savingAccount.createdAt}" pattern="yyyy-MM-dd'T'HH:mm"
                                                   var="parsedCreatedAt" type="both"/>
                                    <fmt:formatDate var="createdAt" value="${parsedCreatedAt}"
                                                    pattern="HH:mm dd/MM/yyyy"/>

                                    <input disabled type="text" class="form-control" id="createdAt"
                                           value="${createdAt}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="createdAt">Last Update At</form:label>
                                    <form:input disabled="true" type="text" class="form-control" path="updatedAt"
                                                placeholder="Enter Password"
                                                value="${savingAccount.updatedAt.toString()}"/>
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

    <c:if test="${authority == 'ADMIN'}">
        <%@ taglib prefix="customer" tagdir="/WEB-INF/tags/customer" %>
        <customer:basicInfo customer="${savingAccount.customer}"/>
    </c:if>

    <%@ taglib prefix="transaction" tagdir="/WEB-INF/tags/transaction" %>
    <%--@elvariable id="transactionList" type="java.util.List<com.se2.bankingsystem.domains.Transaction.entity.Transaction>"--%>
    <transaction:table transactionList="${transactionList}"/>

</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>