<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/prefix.jsp">

    <jsp:param name="title" value="Transactions" />

    <jsp:param name="parentLinkText" value="Manage Transactions" />
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions" />

    <jsp:param name="childLinkText" value="List" />
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions" />

    <jsp:param name="activeSidebarElementID" value="transaction-list" />
</jsp:include>

<!-- START HERE -->

<jsp:include page="nav-tab.jsp">
    <jsp:param name="activeTab" value="all" />
</jsp:include>

<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Transaction</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Create New
            </button>

            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions/create"/>">Charge Transaction</a>
                <a class="dropdown-item" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transferTransactions/create"/>">Transfer Transaction</a>
                <a class="dropdown-item" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions/create"/>">Withdraw Transaction</a>
            </div>
        </div>
    </div>
    <div class="card-block table-border-style">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>From Account</th>
                    <th>Type</th>
                    <th>Created At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="transaction" items="${transactionList}">
                    <tr>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions/${transaction.id}">${transaction.id}</a>
                        </td>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customerAccounts/${transaction.customerAccount.id}">${transaction.customerAccount.id}</a>
                        </td>
                        <td>${transaction.transactionType}</td>

                        <fmt:parseDate value="${transaction.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt" type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy" /></td>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${transaction.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>
                            <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal" data-target="#modalDelete"></i></a>
                        </td>
                    </tr>
                    <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Are you sure to delete?</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-footer d-flex justify-content-md-center">
                                    <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${transaction.id}/delete"><button type="submit" id="btn-yes" class="btn btn-primary">Yes</button></a>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
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
<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/suffix.jsp"/>