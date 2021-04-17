<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Create Customer" />

    <jsp:param name="parentLink" value="Manage Customer" />
    <jsp:param name="parentLinkUrl" value="" />

    <jsp:param name="childLink" value="Create New" />
    <jsp:param name="childLinkUrl" value="" />

    <jsp:param name="activeSidebarElementID" value="add-customer" />
</jsp:include>

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
                    <th>Transaction ID</th>
                    <th>Customer ID</th>
                    <th>Redeem Amount</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="charge" items="${listCharge}">
                    <tr>
                        <td><c:out value="${charge.transactionId}"></c:out></td>
                        <td><c:out value="${charge.customerId}"></c:out></td>
                        <td><c:out value="${charger.redeemAmount}"></c:out></td>

                        <td>
                            <a href="customer-edit?customerId=<c:out value='${customer.customerId}' /> "><i
                                    class="fas fa-edit"></i>Edit</a></td>
                        &nbsp;&nbsp;&nbsp;&nbsp;<a
                            href="customer-delete?customerId=<c:out value='${customer.customerId}' /> "><i
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
