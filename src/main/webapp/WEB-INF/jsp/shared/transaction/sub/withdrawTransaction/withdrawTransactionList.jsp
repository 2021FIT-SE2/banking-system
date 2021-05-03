<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Withdraw Transactions"/>

    <jsp:param name="parentLinkText" value="Manage Withdraw Transactions"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions"/>

    <jsp:param name="activeSidebarElementID" value="withdrawTransaction-list"/>
</jsp:include>

<jsp:include page="../../nav-tab.jsp">
    <jsp:param name="activeTab" value="withdraw"/>
</jsp:include>

<!-- START HERE -->
<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Withdraw Transaction</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <a href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions/create"/>">
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
                    <th>Account</th>
                    <th>Withdraw Amount</th>
                    <th>Wallet Type</th>
                    <th>Create At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="withdrawTransactionList" type="java.util.List"--%>
                <c:forEach var="withdrawTransaction" items="${withdrawTransactionList}">
                    <%--@elvariable id="withdrawTransaction" type="com.se2.bankingsystem.domains.Transaction.sub.WithdrawTransaction.entity.WithdrawTransaction"--%>
                    <tr>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions/${withdrawTransaction.id}">${withdrawTransaction.id}</a>
                        </td>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}/${withdrawTransaction.customerAccount.id}">${withdrawTransaction.customerAccount.id}</a>
                        </td>

                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                            <fmt:formatNumber value="${withdrawTransaction.withdrawAmount}" type="currency"/></td>

                        <td>${withdrawTransaction.wallet.provider}</td>

                        <fmt:parseDate value="${withdrawTransaction.createdAt}" pattern="yyyy-MM-dd'T'HH:mm"
                                       var="createdAt" type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <td>
                                <%--                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions/${withdrawTransaction.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>--%>
                            <i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                               data-target="#modalConfirm"></i></a>
                        </td>
                    </tr>

                    <form action="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions/${withdrawTransaction.id}/delete"
                          method="get">
                        <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                            <jsp:param name="message"
                                       value="Confirm delete Withdraw Transaction with ID ${withdrawTransaction.id}?"/>
                        </jsp:include>
                    </form>

                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>