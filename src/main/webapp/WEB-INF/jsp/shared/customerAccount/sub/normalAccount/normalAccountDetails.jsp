<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="customer" value="${normalAccount.customer}" />

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/prefix.jsp">

    <jsp:param name="title" value="Normal Account Details"/>

    <jsp:param name="parentLinkText" value="Manage Normal Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts"/>

    <jsp:param name="childLinkText" value="Details"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}"/>

    <jsp:param name="activeSidebarElementID" value="normalAccount-list"/>
</jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/customerDetails.css"/>">

<!-- START HERE -->
<div class="container">
    <div class="row gutters">
        <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12 d-flex">
            <div class="card w-100">
                <div class="card-body">
                    <div class="account-settings">
                        <div class="user-profile">
                            <div class="user-avatar">
                                <img src="<c:url value="resources/img/accountant.png"/>" alt="Normal Account Icon">
                            </div>
                            <h5 class="user-name">Normal Account</h5>
                            <h6 class="user-phone-number">${normalAccount.id}</h6>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card">
                <form:form action="" method="post" modelAttribute="normalAccount">
                    <div class="card-body">
                        <div class="row gutters" style="margin-bottom: 10px">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <h6 class="mb-2 text-primary">Normal Account Details</h6>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <label for="id">ID</label>
                                    <input disabled type="text" class="form-control" id="id"
                                           value="${normalAccount.id}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="balance">Balance</form:label>
                                    <form:input type="text" class="form-control" path="balance"
                                                placeholder="Enter Balance" value="${normalAccount.balance}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <label for="createdAt">Created At</label>

                                    <fmt:parseDate value="${normalAccount.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedCreatedAt" type="both"/>
                                    <fmt:formatDate var="createdAt" value="${parsedCreatedAt}" pattern="HH:mm dd/MM/yyyy" />

                                    <input disabled type="text" class="form-control" id="createdAt" value="${createdAt}"/>
                                </fieldset>
                            </div>

                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <fieldset class="form-group">
                                    <form:label path="createdAt">Last Update At</form:label>
                                    <form:input disabled="true" type="text" class="form-control" path="updatedAt"
                                                placeholder="Enter Password"
                                                value="${normalAccount.updatedAt.toString()}"/>
                                </fieldset>
                            </div>
                        </div>

                        <div class="row gutters">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="text-right">
                                    <button type="button" name="submit" class="btn btn-secondary">Cancel</button>
                                    <button type="button" id="submit" name="submit" class="btn btn-primary">Update
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

    <c:if test="${authority == 'ADMIN'}">
        <%@ taglib prefix="customer" tagdir="/WEB-INF/tags/customer"%>
        <customer:basicInfo customer="${normalAccount.customer}" />
    </c:if>

    <div class="card" style="margin-top: 20px">
        <div class="card-header">
            <h5>Transactions</h5>
            <div class="card-header-right" style="margin-right: 10px">
                <a href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/customerAccounts/create"/>">
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
                        <th>Type</th>
                        <th>Created At</th>
                        <th>Updated At</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="transaction" items="${transactionList}">
                        <tr>
                            <td>
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions/${transaction.id}">${transaction.id}</a>
                            </td>
                            <td>${transaction.transactionType}</td>

                            <fmt:parseDate value="${transaction.createdAt}" pattern="yyyy-MM-dd" var="createdAt"
                                           type="date"/>
                            <td><fmt:formatDate value="${createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                            <fmt:parseDate value="${transaction.updatedAt}" pattern="yyyy-MM-dd" var="updatedAt"
                                           type="date"/>
                            <td><fmt:formatDate value="${updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>

                            <td>
                                <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions/${transaction.id}/edit"><i
                                        class="ti-pencil-alt fa-2x text-primary"></i></a>
                                <a><i class="ti-trash fa-2x text-danger" id="icon-delete" data-toggle="modal"
                                      data-target="#modalDelete"></i></a>
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
                                        <a href="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${transaction.id}/delete">
                                            <button type="submit" id="btn-yes" class="btn btn-primary">Yes</button>
                                        </a>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
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
</div>
<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/suffix.jsp"/>