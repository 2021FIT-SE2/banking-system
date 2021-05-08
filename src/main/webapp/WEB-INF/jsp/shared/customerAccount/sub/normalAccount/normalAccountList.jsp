<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Normal Account"/>

    <jsp:param name="parentLinkText" value="Manage Normal Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts"/>

    <jsp:param name="activeSidebarElementID" value="normalAccount-list"/>
</jsp:include>

<!-- START HERE -->

<jsp:include page="../../nav-tab.jsp">
    <jsp:param name="activeTab" value="normal"/>
</jsp:include>

<!-- START HERE -->
<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Normal Accounts</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <c:if test="${authority == 'ADMIN'}">
                <a href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/create"/>">
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
                    <th>Balance</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="normalAccountList" scope="request" type="java.util.List"/>
                <c:forEach var="normalAccount" items="${normalAccountList}">
                    <%--@elvariable id="normalAccount" type="com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount"--%>
                    <tr>
                        <td>
                            <a class="d-inline-block text-truncate" style="max-width: 100px"
                               href="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}">${normalAccount.id}</a>
                        </td>
                        <c:if test="${authority == 'ADMIN'}">
                            <td>
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${normalAccount.customer.id}">${normalAccount.customer.id}</a>
                            </td>
                        </c:if>
                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                            <fmt:formatNumber value="${normalAccount.balance}" type="currency"/></td>

                        <fmt:parseDate value="${normalAccount.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <fmt:parseDate value="${normalAccount.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <td>
                            <a style="margin-right: 5px"
                               href="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}"><i
                                    class="ti-info-alt fa-2x text-secondary"></i></a>
                            <c:if test="${authority == 'ADMIN'}">
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}/edit"><i
                                        class="ti-pencil-alt fa-2x text-primary"></i></a>
                                <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                      data-target="#modalConfirm"></i></a>
                                <form action="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}/delete"
                                      method="get">
                                    <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                                        <jsp:param name="message"
                                                   value="Confirm delete Normal Account with ID ${normalAccount.id}?"/>
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