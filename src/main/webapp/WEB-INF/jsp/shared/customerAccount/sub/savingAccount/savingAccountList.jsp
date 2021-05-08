<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Saving Account"/>

    <jsp:param name="parentLinkText" value="Manage Saving Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts"/>

    <jsp:param name="activeSidebarElementID" value="savingAccount-list"/>
</jsp:include>

<!-- START HERE -->

<jsp:include page="../../nav-tab.jsp">
    <jsp:param name="activeTab" value="saving"/>
</jsp:include>

<!-- START HERE -->
<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Saving Accounts</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <c:if test="${authority == 'ADMIN'}">
                <a href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/create"/>">
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
                    <th>Current Saving</th>
                    <th>Duration</th>
                    <th>Start Date</th>
                    <th>Last Update At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>

                <%--@elvariable id="savingAccountList" type="java.util.List<com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingAccount>"--%>
                <c:forEach var="savingAccount" items="${savingAccountList}">
                    <tr>
                        <td>
                            <a class="d-inline-block text-truncate" style="max-width: 100px"
                               href="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/${savingAccount.id}">${savingAccount.id}</a>
                        </td>
                        <c:if test="${authority == 'ADMIN'}">
                            <td>
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${savingAccount.customer.id}">${savingAccount.customer.id}</a>
                            </td>
                        </c:if>
                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                            <fmt:formatNumber value="${savingAccount.currentSaving}" type="currency"/></td>
                        <td>${savingAccount.savingDuration.translation()}</td>

                        <fmt:parseDate value="${savingAccount.startDate}" pattern="yyyy-MM-dd" var="startDate"
                                       type="date"/>
                        <td><fmt:formatDate value="${startDate}" pattern="dd/MM/yyyy"/></td>

                        <fmt:parseDate value="${savingAccount.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <td>
                            <a style="margin-right: 5px"
                               href="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/${savingAccount.id}"><i
                                    class="ti-info-alt fa-2x text-secondary"></i></a>
                            <c:if test="${authority == 'ADMIN'}">
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/${savingAccount.id}/edit"><i
                                        class="ti-pencil-alt fa-2x text-primary"></i></a>
                                <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                      data-target="#modalConfirm"></i></a>
                                <form action="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts/${savingAccount.id}/delete"
                                      method="get">
                                    <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                                        <jsp:param name="message"
                                                   value="Confirm delete Saving Account with ID ${savingAccount.id}?"/>
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