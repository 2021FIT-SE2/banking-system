<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Customer Details" />

    <jsp:param name="parentLinkText" value="Manage Customer" />
    <jsp:param name="parentLinkUrl" value="/admin/customers" />

    <jsp:param name="childLinkText" value="Customer Details" />
    <jsp:param name="childLinkUrl" value="/admin/customers/1/details" />

    <jsp:param name="activeSidebarElementID" value="add-customer" />
</jsp:include>
<!-- START HERE -->
<div class="card">
    <div class="card-header">
        <h5>Hover Table</h5>
        <span>use class <code>table-hover</code> inside table element</span>
        <div class="card-header-right">
            <ul class="list-unstyled card-option">
                <li><i class="fa fa fa-wrench open-card-option"></i></li>
                <li><i class="fa fa-window-maximize full-card"></i></li>
                <li><i class="fa fa-minus minimize-card"></i></li>
                <li><i class="fa fa-refresh reload-card"></i></li>
                <li><i class="fa fa-trash close-card"></i></li>
            </ul>
        </div>
    </div>
    <div class="card-block table-border-style">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Customer ID</th>
                    <th>Full Name</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Account Number</th>
                    <th>Type of Account</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${}">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.fullName}</td>
                        <td>${customer.dob}</td>
                        <td>${customer.gender}</td>
                        <td>${customer.password}</td>
                        <td>${customer.address}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.accountNumber}</td>
                        <td>${customer.accountType}</td>
                        <td><a href="customer-edit?customerId=${customer.customerId}"><i
                                class="fas fa-edit"></i>Edit</a></td>
                        &nbsp;&nbsp;&nbsp;&nbsp;<a
                            href="customer-delete?customerId=${customer.customerId}"><i
                            class="fas fa-trash-alt"></i>Delete</a>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>