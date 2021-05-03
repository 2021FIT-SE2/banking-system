<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="customerAccountList" required="true"
              type="java.util.List<com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount>" %>
<%@ taglib prefix="account" tagdir="/WEB-INF/tags/account" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>
<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Customer Account</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Create New
            </button>

            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item"
                   href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/create"/>">Normal
                    Account</a>
                <a class="dropdown-item"
                   href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts/create"/>">Loan
                    Account</a>
                <a class="dropdown-item"
                   href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/create"/>">Saving
                    Account</a>
            </div>
        </div>
    </div>
    <div class="card-block table-border-style">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <c:if test="${authority == 'ADMIN'}">
                        <th>Owner ID</th>
                    </c:if>
                    <th>Type</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>

                <%--@elvariable id="customerAccountList" type="java.util.List<com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount>"--%>
                <c:forEach var="customerAccount" items="${customerAccountList}">
                    <tr>
                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}/${customerAccount.id}">${customerAccount.id}</a>
                        </td>
                        <c:if test="${authority == 'ADMIN'}">
                            <td>
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${customerAccount.customer.id}">${customerAccount.customer.id}</a>
                            </td>
                        </c:if>

                        <td>${customerAccount.accountType.name()}</td>

                        <fmt:parseDate value="${customerAccount.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <fmt:parseDate value="${customerAccount.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <td>
                            <a style="margin-right: 5px"
                               href="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}/${customerAccount.id}"><i
                                    class="ti-info-alt fa-2x text-secondary"></i></a>
                            <c:if test="${authority == 'ADMIN'}">
                                <a href="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}/${customerAccount.id}/edit"><i
                                        class="ti-pencil-alt fa-2x text-primary"></i></a>
                                <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                      data-target="#modalConfirm"></i></a>
                                <form action="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions/${transaction.id}/delete"
                                      method="get">
                                    <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                                        <jsp:param name="message"
                                                   value="Confirm delete Transfer Transaction with ID ${transferTransaction.id}?"/>
                                    </jsp:include>
                                </form>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>