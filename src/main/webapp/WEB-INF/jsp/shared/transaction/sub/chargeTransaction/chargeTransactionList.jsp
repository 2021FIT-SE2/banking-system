<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Charge Transactions"/>

    <jsp:param name="parentLinkText" value="Manage Charge Transactions"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions"/>

    <jsp:param name="activeSidebarElementID" value="chargeTransaction-list"/>
</jsp:include>

<!-- START HERE -->

<jsp:include page="../../nav-tab.jsp">
    <jsp:param name="activeTab" value="charge"/>
</jsp:include>

<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Charge Transaction</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <a href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions/create"/>">
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
                    <th>Redeem Amount</th>
                    <th>Created At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="chargeTransactionList" type="java.util.List"--%>
                <c:forEach var="chargeTransaction" items="${chargeTransactionList}">
                    <%--@elvariable id="chargeTransaction" type="com.se2.bankingsystem.domains.Transaction.sub.ChargeTransaction.entity.ChargeTransaction"--%>
                    <tr>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions/${chargeTransaction.id}">${chargeTransaction.id}</a>
                        </td>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}/${chargeTransaction.customerAccount.id}">${chargeTransaction.customerAccount.id}</a>
                        </td>

                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                            <fmt:formatNumber value="${chargeTransaction.redeemAmount}" type="currency"/></td>

                        <fmt:parseDate value="${chargeTransaction.createdAt}" pattern="yyyy-MM-dd'T'HH:mm"
                                       var="createdAt" type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <td>
                                <%--                            <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions/${chargeTransaction.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>--%>
                            <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                  data-target="#modalConfirm"></i></a>
                        </td>
                    </tr>
                    <form action="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions/${chargeTransaction.id}/delete"
                          method="get">
                        <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                            <jsp:param name="message"
                                       value="Confirm delete Charge Transaction with ID ${chargeTransaction.id}?"/>
                        </jsp:include>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="${commonPrefix}/success-dialog.jsp"/>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>