<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/commons/admin/prefix.jsp"/>
<!-- START HERE -->
<div class="card">
    <div class="card-header">
        <h5>Transfer Transaction</h5>
        <div class="card-header-right" style="margin-right: 10px">
            <a href="<c:url value="/admin/transferTransactions/create"/>">
                <button type="submit" class="btn btn-primary">Create New</button>
            </a>
        </div>
    </div>
    <div class="card-block table-border-style">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Transfer Transaction ID</th>
                    <th>Customer Account ID</th>
                    <th>Beneficial Account</th>
                    <th>Redeem Amount</th>
                    <th>Create At</th>
                    <th>Update At</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="transferTransaction" items="${transferTransactionList}">
                    <tr>
                        <td>
                            <a href="/admin/transferTransactions/${transferTransaction.id}">${transferTransaction.id}</a>
                        </td>
                        <td>
                            <a href="/admin/customers/${transferTransaction.customerAccountId}">${transferTransaction.customerAccountId}</a>
                        </td>
                        <td>${transferTransaction.beneficialAccount}</td>
                        <td>${transferTransaction.transferAmount}</td>
                        <td>${transferTransaction.createdAt}</td>
                        >
                        <td>${transferTransaction.updateAt}</td>
                        <td>${transferTransaction.status}</td>
                        <td>
                            <a href="/admin/transferTransactions/${transferTransaction.id}/edit"><i
                                    class="ti-pencil-alt fa-2x text-primary"></i></a>
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
                                    <a href="/admin/transferTransactions/${transferTransaction.id}/delete"><button type="submit" id="btn-yes" class="btn btn-primary">Yes</button></a>
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