<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Loan Account"/>

    <jsp:param name="parentLinkText" value="Manage Loan Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts"/>

    <jsp:param name="activeSidebarElementID" value="loanAccount-list"/>
</jsp:include>

<!-- START HERE -->

<jsp:include page="../../nav-tab.jsp">
    <jsp:param name="activeTab" value="loan"/>
</jsp:include>

<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Loan Accounts</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <c:if test="${authority == 'ADMIN'}">
                <a href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts/create"/>">
                    <button type="submit" class="btn btn-primary">Create New</button>
                </a>
            </c:if>
        </div>
    </div>
    <div class="card-block table-border-style">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <c:if test="${authority == 'ADMIN'}">
                        <th>Customer ID</th>
                    </c:if>
                    <th>Current Loan</th>
                    <th>Duration</th>
                    <th>Start Date</th>
                    <th>Last Update At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="loanAccountList" scope="request" type="java.util.List"/>
                <c:forEach var="loanAccount" items="${loanAccountList}">
                    <%--@elvariable id="loanAccount" type="com.se2.bankingsystem.domains.CustomerAccount.sub.LoanAccount.entity.LoanAccount"--%>

                    <tr>
                        <td>
                            <a class="d-inline-block text-truncate" style="max-width: 100px"
                               href="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts/${loanAccount.id}">${loanAccount.id}</a>
                        </td>
                        <c:if test="${authority == 'ADMIN'}">
                            <td>
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${loanAccount.customer.id}">${loanAccount.customer.id}</a>
                            </td>
                        </c:if>
                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                            <fmt:formatNumber value="${loanAccount.currentLoan}" type="currency"/></td>
                        <td>${loanAccount.loanDuration.translation()}</td>

                        <fmt:parseDate value="${loanAccount.startDate}" pattern="yyyy-MM-dd" var="startDate"
                                       type="date"/>
                        <td><fmt:formatDate value="${startDate}" pattern="dd/MM/yyyy"/></td>

                        <fmt:parseDate value="${loanAccount.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <td>
                            <a style="margin-right: 5px"
                               href="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts/${loanAccount.id}"><i
                                    class="ti-info-alt fa-2x text-secondary"></i></a>
                            <c:if test="${authority == 'ADMIN'}">
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts/${loanAccount.id}/edit"><i
                                        class="ti-pencil-alt fa-2x text-primary"></i></a>
                                <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                      data-target="#modalConfirm"></i></a>
                                <form action="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts/${loanAccount.id}/delete"
                                      method="get">
                                    <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                                        <jsp:param name="message" value="Confirm delete Loan Account with ID ${loanAccount.id}?"/>
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

<jsp:include page="${commonPrefix}/success-dialog.jsp"/>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>