<%--@elvariable id="normalAccount" type="com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.entity.NormalAccount"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Edit Normal Account"/>

    <jsp:param name="parentLinkText" value="Manage Normal Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts"/>

    <jsp:param name="childLinkText" value="Edit"/>
    <jsp:param name="childLinkUrl"
               value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/${normalAccount.id}/edit"/>

    <jsp:param name="activeSidebarElementID" value="edit-normalAccounts"/>
</jsp:include>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Edit Normal Account ${normalAccount.id}</h5>
            </div>
            <div class="card-block">
                <%--@elvariable id="updateNormalAccountDTO" type="com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.UpdateNormalAccountDTO"--%>
                <form:form method="post" modelAttribute="updateNormalAccountDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <label for="customerID" class="col-sm-3 col-form-label">Customer ID</label>
                        <div class="col-sm-9">
                            <input disabled id="customerID" type="number" class="form-control"
                                   value="${normalAccount.customer.id}"/>
                            <span class="form-bar"></span>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="balance">Balance</form:label>
                        <div class="col-sm-9">
                            <form:input path="balance" type="number" class="form-control"
                                        required="required" value="${normalAccount.balance}"/>
                            <span class="form-bar"></span>
                            <form:errors path="balance" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <br><br>
                    <div class="d-flex justify-content-md-center">
                        <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal"
                                data-target="#modalConfirm">Add
                        </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>

                    <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                        <jsp:param name="message" value="Confirm updating this Normal Account?"/>
                    </jsp:include>
                </form:form>
            </div>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>