<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Manage Customers"/>

    <jsp:param name="parentLinkText" value="Manage Customers"/>
    <jsp:param name="parentLinkUrl" value="/admin/customers"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/admin/customers"/>

    <jsp:param name="activeSidebarElementID" value="customer-list"/>
</jsp:include>

<!-- START HERE -->
<div class="card">
    <div class="card-header">
        <h5>All Customers</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <a href="<c:url value="/admin/customers/create"/>">
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
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>
                            <a href="/admin/customers/${customer.id}">${customer.username}</a>
                        </td>
                        <td>${customer.email}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.gender}</td>
                        <td>${customer.address}</td>
                        <td>
                            <a href="/admin/customers/${customer.id}/edit"><i
                                    class="ti-pencil-alt fa-2x text-primary"></i></a>
                            <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                  data-target="#modalConfirm"></i></a>
                        </td>
                    </tr>
                    <form action="/admin/customers/${customer.id}/delete" method="get">
                        <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                            <jsp:param name="message" value="Confirm delete Customer with ID ${customer.id}?"/>
                        </jsp:include>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>