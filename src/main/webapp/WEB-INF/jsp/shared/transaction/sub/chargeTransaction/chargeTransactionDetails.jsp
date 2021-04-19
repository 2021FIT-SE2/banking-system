<jsp:include page="/WEB-INF/commons/admin/prefix.jsp"/>

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
                    <th>Charge Transaction ID</th>
                    <th>Customer's account ID</th>
                    <th>Redeem Amount</th>
                    <th>Create At</th>
                    <th>Update At</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="chargeTransaction" items="${chargeTransactionList}">
                    <tr>
                        <td>${chargeTransaction.id}</td>
                        <td>${chargeTransaction.customerAccountId}</td>
                        <td>${chargeTransaction.redeemAmount}</td>
                        <td>${chargeTransaction.createAt}</td>
                        <td>${chargeTransaction.UpdateAt}</td>

                        <td>
                            <a href="customer-edit?customerId=${chargeTransaction.id}"><i
                                    class="fas fa-edit"></i>Edit</a></td>
                        &nbsp;&nbsp;&nbsp;&nbsp;<a
                            href="customer-delete?customerId=${chargeTransaction.id}"><i
                            class="fas fa-trash-alt"></i>Delete</a>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>
