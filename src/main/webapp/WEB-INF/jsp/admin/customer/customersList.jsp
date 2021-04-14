<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/commons/admin/prefix.jsp"/>
<!-- START HERE -->
<div class="card">
    <div class="card-header">
        <h5>Customers</h5>
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
                            <a href="/admin/customers/${customer.id}/edit"><i class="ti-pencil-alt fa-2x text-primary"></i></a>
                            <a href="/admin/customers/${customer.id}/delete"><i class="ti-trash fa-2x text-danger"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>