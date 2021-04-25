<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/commons/admin/prefix.jsp">

    <jsp:param name="title" value="Edit Normal Account"/>

    <jsp:param name="parentLink" value="Manage normal account"/>
    <jsp:param name="parentLinkUrl" value=""/>

    <jsp:param name="childLink" value="Edit normal account"/>
    <jsp:param name="childLinkUrl" value=""/>

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
                <form:form method="post" modelAttribute="updateNormalAccountDTO" cssClass="form-material">
                    <fieldset class="form-group row row">
                        <label for="customerID" class="col-sm-3 col-form-label">Customer ID</label>
                        <div class="col-sm-9">
                            <input disabled id="customerID" type="number" class="form-control" value="${normalAccount.customer.id}"/>
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
                        <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal" data-target="#modalSave">Add</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/commons/admin/save-confirm.jsp"/>

<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/admin/suffix.jsp"/>