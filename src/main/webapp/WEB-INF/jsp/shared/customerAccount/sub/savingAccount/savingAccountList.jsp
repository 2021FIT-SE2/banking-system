<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Saving Account" />

    <jsp:param name="parentLinkText" value="Manage Saving Account" />
    <jsp:param name="parentLinkUrl" value="/admin/savingAccounts" />

    <jsp:param name="childLinkText" value="List" />
    <jsp:param name="childLinkUrl" value="/admin/savingAccounts" />

    <jsp:param name="activeSidebarElementID" value="savingAccount-list" />
</jsp:include>

<!-- START HERE -->

<jsp:include page="../../nav-tab.jsp">
    <jsp:param name="activeTab" value="saving" />
</jsp:include>

<!-- START HERE -->
<div class="card" style="margin-top: 20px">
    <div class="card-header">
        <h5>savingAccounts</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <a href="<c:url value="/admin/savingAccounts/create"/>">
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
                    <th>Balance</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="savingAccount" items="${savingAccountList}">
                    <tr>
                        <td>${savingAccount.id}</td>
                        <td>
                            <a href="/admin/savingAccounts/${savingAccount.customerID}">${savingAccount.customerID}</a>
                        </td>
                        <td>${savingAccount.balance}</td>

                        <td>
                            <a href="/admin/savingAccounts/${savingAccount.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>
                            <i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal" data-target="#modalDelete"></i></a>
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
                                    <a href="/admin/savingAccounts/${savingAccount.id}/delete"><button type="submit" id="btn-yes" class="btn btn-primary">Yes</button></a>
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