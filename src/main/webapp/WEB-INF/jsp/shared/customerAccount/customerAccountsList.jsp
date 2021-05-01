<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/prefix.jsp">

    <jsp:param name="title" value="Account" />

    <jsp:param name="parentLinkText" value="Manage Account" />
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}" />

    <jsp:param name="childLinkText" value="List" />
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}" />

    <jsp:param name="activeSidebarElementID" value="customerAccount-list" />
</jsp:include>

<!-- START HERE -->

<jsp:include page="nav-tab.jsp">
    <jsp:param name="activeTab" value="all" />
</jsp:include>

<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Customer Account</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Create New
            </button>

            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/create"/>">Normal Account</a>
                <a class="dropdown-item" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts/create"/>">Loan Account</a>
                <a class="dropdown-item" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/create"/>">Saving Account</a>
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

                <jsp:useBean id="customerAccountList" scope="request" type="java.util.List"/>
                <c:forEach var="customerAccount" items="${customerAccountList}">
                    <%--@elvariable id="customerAccount" type="com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount"--%>

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

                        <fmt:parseDate value="${customerAccount.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt" type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy" /></td>

                        <fmt:parseDate value="${customerAccount.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt" type="both"/>
                        <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy" /></td>

                        <td>
                            <a href="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}/${customerAccount.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>
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
                                    <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${customerAccount.id}/delete"><button type="submit" id="btn-yes" class="btn btn-primary">Yes</button></a>
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