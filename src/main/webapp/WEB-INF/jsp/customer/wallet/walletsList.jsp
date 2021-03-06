<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Manage Wallets"/>

    <jsp:param name="parentLinkText" value="Manage Wallets"/>
    <jsp:param name="parentLinkUrl" value="/me/wallets"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/me/wallets"/>

    <jsp:param name="activeSidebarElementID" value="wallet-list"/>
</jsp:include>

<!-- START HERE -->
<div class="card">
    <div class="card-header">
        <h5>All Wallets</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <%--            <a href="<c:url value="/me/wallets/create"/>">--%>
            <%--                <button type="submit" class="btn btn-primary">Create New</button>--%>
            <%--            </a>--%>
        </div>
    </div>
    <div class="card-block table-border-style">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Balance</th>
                    <th>Provider</th>
                    <th>Added At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="wallet" items="${fakeEWalletList}">
                    <tr>
                        <td>
                            <a href="/me/wallets/${wallet.id}">${wallet.id}</a>
                        </td>
                        <td>${wallet.balance}</td>
                        <td>${wallet.provider}</td>

                        <fmt:parseDate value="${wallet.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="createdAt"
                                       type="both"/>
                        <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                        <td>
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
                                    <a href="/me/wallets/${wallet.id}/delete">
                                        <button type="submit" id="btn-yes" class="btn btn-primary">Yes</button>
                                    </a>
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
<jsp:include page="${commonPrefix}/suffix.jsp"/>