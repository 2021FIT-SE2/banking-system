<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Create Normal Account"/>

    <jsp:param name="parentLinkText" value="Manage Normal Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts"/>

    <jsp:param name="childLinkText" value="Create"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts/create"/>

    <jsp:param name="activeSidebarElementID" value="add-normalAccounts"/>
</jsp:include>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Add a new Normal account</h5>
            </div>
            <div class="card-block">
                <%--@elvariable id="createNormalAccountDTO" type="com.se2.bankingsystem.domains.CustomerAccount.sub.NormalAccount.dto.CreateNormalAccountDTO"--%>
                <form:form method="post" modelAttribute="createNormalAccountDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="customerID">Customer ID</form:label>
                        <div class="col-sm-9">
                            <form:input path="customerID" type="number" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="customerID" cssClass="text-warning"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group row row">
                        <form:label cssClass="col-sm-3 col-form-label" path="balance">Balance</form:label>
                        <div class="col-sm-9">
                            <form:input path="balance" type="number" class="form-control"
                                        required="required" value="50000"/>
                            <span class="form-bar"></span>
                            <form:errors path="balance" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <br><br>
                    <div class="d-flex justify-content-md-center">
                        <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal"
                                data-target="#modalConfirm">Add
                        </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button id="btn-reset" type="button" class="btn btn-danger">Reset</button>
                    </div>
                    <jsp:include page="${commonPrefix}/confirm-dialog.jsp">
                        <jsp:param name="message" value="Confirm adding this Normal Account?"/>
                    </jsp:include>
                </form:form>
            </div>
        </div>
    </div>
</div>
<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>