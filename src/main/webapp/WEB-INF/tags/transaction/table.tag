<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="transactionList" required="true"
              type="java.util.List<com.se2.bankingsystem.domains.Transaction.entity.Transaction>" %>
<%@ taglib prefix="transaction" tagdir="/WEB-INF/tags/transaction" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>
<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Transaction</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Create New
            </button>

            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item"
                   href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions/create"/>">Charge
                    Transaction</a>
                <a class="dropdown-item"
                   href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transferTransactions/create"/>">Transfer
                    Transaction</a>
                <a class="dropdown-item"
                   href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions/create"/>">Withdraw
                    Transaction</a>
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
                <%--@elvariable id="transactionList" type="java.util.List"--%>
                <c:forEach var="transaction" items="${transactionList}">
                    <%--@elvariable id="transaction" type="com.se2.bankingsystem.domains.Transaction.entity.Transaction"--%>
                    <tr>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions/${transaction.id}">${transaction.id}</a>
                        </td>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}/${transaction.customerAccount.id}">${transaction.customerAccount.id}</a>
                        </td>
                        <td>${transaction.transactionType}</td>

                        <fmt:parseDate value="${transaction.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>
                        <td>
                                <%--                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${transaction.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>--%>
                            <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                  data-target="#modalConfirm"></i></a>
                        </td>
                    </tr>

                    <form action="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions/${transaction.id}/delete"
                          method="get">
                        <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                            <jsp:param name="message" value="Confirm delete Transaction with ID ${transaction.id}?"/>
                        </jsp:include>
                    </form>

                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>