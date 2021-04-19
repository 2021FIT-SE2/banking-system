<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Customer Account" />

    <jsp:param name="parentLinkText" value="Manage Customer Account" />
    <jsp:param name="parentLinkUrl" value="/admin/customerAccounts" />

    <jsp:param name="childLinkText" value="List" />
    <jsp:param name="childLinkUrl" value="/admin/customerAccounts" />

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
            <a href="<c:url value="/admin/customerAccounts/create"/>">
                <button type="submit" class="btn btn-primary">Create New</button>
            </a>
        </div>
    </div>
    <div class="card-block table-border-style">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customerAccount" items="${customerAccountList}">
                    <tr>
                        <td>${customerAccount.id}</td>
                        <td>
                            <a href="/admin/customers/${customerAccount.id}">${customerAccount.username}</a>
                        </td>
                        <td>${customerAccount.email}</td>
                        <td>${customerAccount.phoneNumber}</td>
                        <td>${customerAccount.firstName}</td>
                        <td>${customerAccount.lastName}</td>
                        <td>${customerAccount.gender}</td>
                        <td>${customerAccount.address}</td>
                        <td>
                            <a href="/admin/customers/${customerAccount.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>
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
                                    <a href="/admin/customers/${customerAccount.id}/delete"><button type="submit" id="btn-yes" class="btn btn-primary">Yes</button></a>
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