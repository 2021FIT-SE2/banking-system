<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="normalAccount" type="com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount"--%>
<c:set var="customer" value="${normalAccount.customer}"/>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Normal Account Details"/>

    <jsp:param name="parentLinkText" value="Manage Normal Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts"/>

    <jsp:param name="childLinkText" value="Details"/>
    <jsp:param name="childLinkUrl"
               value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}"/>

    <jsp:param name="activeSidebarElementID" value="normalAccount-list"/>
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
                                <img src="<c:url value="resources/img/accountant.png"/>" alt="Normal Account Icon">
                            </div>
                            <h5 class="user-name">Normal Account</h5>
                            <h6 class="user-phone-number">${normalAccount.id}</h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card">
                <form:form action="" method="post" modelAttribute="normalAccount">
                    <div class="card-body">
                        <div class="row gutters" style="margin-bottom: 10px">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
                                <h6 class="mb-2 text-primary">Normal Account Details</h6>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
                                <div class="text-right">
                                    <c:if test="${authority == 'ADMIN'}">
                                        <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}/edit"><i
                                                class="ti-pencil-alt fa-2x text-primary"></i></a>
                                        <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                              data-target="#modalConfirm"></i></a>
                                    </c:if>
                                </div>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <label for="id">ID</label>
                                    <input readonly type="text" class="form-control" id="id"
                                           value="${normalAccount.id}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="balance">Balance</form:label>
                                    <form:input readonly="true" type="text" class="form-control" path="balance"
                                                placeholder="Enter Balance" value="${normalAccount.balance}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <label for="createdAt">Created At</label>

                                    <fmt:parseDate value="${normalAccount.createdAt}" pattern="yyyy-MM-dd'T'HH:mm"
                                                   var="parsedCreatedAt" type="both"/>
                                    <fmt:formatDate var="createdAt" value="${parsedCreatedAt}"
                                                    pattern="HH:mm dd/MM/yyyy"/>

                                    <input readonly type="text" class="form-control" id="createdAt"
                                           value="${createdAt}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="createdAt">Last Update At</form:label>
                                    <form:input readonly="true" type="text" class="form-control" path="updatedAt"
                                                placeholder="Enter Password"
                                                value="${normalAccount.updatedAt.toString()}"/>
                                </fieldset>
                            </div>
                        </div>

                    </div>
                </form:form>
            </div>
        </div>
    </div>

    <c:if test="${authority == 'ADMIN'}">
        <%@ taglib prefix="customer" tagdir="/WEB-INF/tags/customer" %>
        <customer:basicInfo customer="${normalAccount.customer}"/>
    </c:if>

    <%@ taglib prefix="transaction" tagdir="/WEB-INF/tags/transaction" %>
    <%--@elvariable id="transactionList" type="java.util.List<com.se2.bankingsystem.domains.Transaction.entity.Transaction>"--%>
    <transaction:table transactionList="${transactionList}"/>

</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>