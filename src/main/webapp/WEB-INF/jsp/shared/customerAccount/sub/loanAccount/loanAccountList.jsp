<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Loan Account" />

    <jsp:param name="parentLinkText" value="Manage Loan Account" />
    <jsp:param name="parentLinkUrl" value="/admin/loanAccounts" />

    <jsp:param name="childLinkText" value="List" />
    <jsp:param name="childLinkUrl" value="/admin/loanAccounts" />

    <jsp:param name="activeSidebarElementID" value="normalAccount-list" />
</jsp:include>

<!-- START HERE -->

<jsp:include page="../../nav-tab.jsp">
    <jsp:param name="activeTab" value="loan" />
</jsp:include>

<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>Loan Accounts</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <a href="<c:url value="/admin/loanAccounts/create"/>">
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
                    <th>Customer ID</th>
                    <th>Current Loan</th>
                    <th>Duration</th>
                    <th>Start Date</th>
                    <th>Last Update At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="loanAccount" items="${loanAccountList}">
                    <tr>
                        <td>
                            <a class="d-inline-block text-truncate" style="max-width: 100px" href="/admin/loanAccounts/${loanAccount.id}">${loanAccount.id}</a>
                        </td>
                        <td>
                            <a href="/admin/customers/${loanAccount.customer.id}">${loanAccount.customer.id}</a>
                        </td>
                        <td><fmt:setLocale value="vi_VN" scope="session"/>
                            <fmt:formatNumber value="${loanAccount.currentLoan}" type = "currency"/></td>
                        <td>${loanAccount.loanDuration.translation()}</td>

                        <fmt:parseDate value="${loanAccount.startDate}" pattern="yyyy-MM-dd" var="startDate" type="date"/>
                        <td><fmt:formatDate value="${startDate}" pattern="dd/MM/yyyy" /></td>

                        <fmt:parseDate value="${loanAccount.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm" var="updatedAt" type="both"/>
                        <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy" /></td>

                        <td>
                            <a href="/admin/loanAccounts/${loanAccount.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>
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
                                    <a href="/admin/loanAccounts/${loanAccount.id}/delete"><button type="submit" id="btn-yes" class="btn btn-primary">Yes</button></a>
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
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>