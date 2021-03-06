<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Wallet Details"/>

    <jsp:param name="parentLinkText" value="Manage Wallet"/>
    <jsp:param name="parentLinkUrl" value="/me/"/>

    <jsp:param name="childLinkText" value="Wallet Details"/>
    <jsp:param name="childLinkUrl" value="/me/wallets/${fakeEWallet.id}/details"/>

    <jsp:param name="activeSidebarElementID" value="wallet-details"/>
</jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/customerDetails.css"/>">

<!-- START HERE -->
<div class="container">
    <div class="row gutters">
        <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <div class="card-body">
                    <div class="account-settings">
                        <div class="user-profile">
                            <div class="user-avatar">
                                <c:choose>
                                    <c:when test="${fakeEWallet.provider.name() == 'ZALO'}">
                                        <img src="<c:url value="resources/img/zalo-logo.png"/>" alt="Maxwell Admin">
                                    </c:when>
                                    <c:when test="${fakeEWallet.provider.name() == 'AIRPAY'}">
                                        <img src="<c:url value="resources/img/airpay-logo.png"/>" alt="Maxwell Admin">
                                    </c:when>
                                    <c:when test="${fakeEWallet.provider.name() == 'MOMO'}">
                                        <img src="<c:url value="resources/img/momo-logo.png"/>" alt="Maxwell Admin">
                                    </c:when>
                                </c:choose>
                            </div>
                            <h5 class="user-name">ID: ${fakeEWallet.id}</h5>
                            <h6 class="user-phone-number">${fakeEWallet.provider}</h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <form:form action="" method="post" modelAttribute="fakeEWallet">
                    <div class="card-body">

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

    <div class="card" style="margin-top: 20px">
        <div class="card-header">
            <h5>Withdraw Transactions</h5>
            <div class="card-header-right" style="margin-right: 10px">
                <a href="<c:url value="/admin/withdrawTransactions/create"/>">
                    <button type="submit" class="btn btn-primary">Create New</button>
                </a>
            </div>
        </div>
        <div class="card-block table-border-style">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Amount</th>
                        <th>From Account</th>
                        <th>Created At</th>
                        <th>Updated At</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="withdrawTransaction" items="${withdrawTransactionList}">
                        <tr>
                            <td>
                                <a href="/admin/withdrawTransactions/${withdrawTransaction.id}">${withdrawTransaction.id}</a>
                            </td>
                            <td>${withdrawTransaction.withdrawAmount}</td>
                            <td>${withdrawTransaction.customerAccount.id}</td>

                            <fmt:parseDate value="${withdrawTransaction.createdAt}" pattern="yyyy-MM-dd" var="createdAt"
                                           type="date"/>
                            <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                            <fmt:parseDate value="${withdrawTransaction.updatedAt}" pattern="yyyy-MM-dd" var="updatedAt"
                                           type="date"/>
                            <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                            <td>
                                <a href="/admin/withdrawTransactions/${withdrawTransaction.id}/edit"><i
                                        class="ti-pencil-alt fa-2x text-primary"></i></a>
                                <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                      data-target="#modalConfirm"></i></a>
                            </td>
                        </tr>
                        <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Are you sure to delete?</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-footer d-flex justify-content-md-center">
                                        <a href="/admin/customers/${withdrawTransaction.id}/delete">
                                            <button type="submit" id="btn-yes" class="btn btn-primary">Yes</button>
                                        </a>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>