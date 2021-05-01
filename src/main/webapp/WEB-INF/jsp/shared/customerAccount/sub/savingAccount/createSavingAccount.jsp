<%@ page import="com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.entity.SavingDuration" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("savingDurations", SavingDuration.values()); %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/prefix.jsp">

    <jsp:param name="title" value="Create saving account"/>

    <jsp:param name="parentLink" value="Manage saving account"/>
    <jsp:param name="parentLinkUrl" value=""/>

    <jsp:param name="childLink" value="Create New saving account"/>
    <jsp:param name="childLinkUrl" value=""/>

    <jsp:param name="activeSidebarElementID" value="add-savingAccounts"/>
</jsp:include>

<!-- START HERE -->
<div class="row h-100 justify-content-center align-items-center">
    <div class="col-md-8">
        <div class="card">
            <div class="card-header">
                <h5>Add a new saving account</h5>
            </div>
            <div class="card-block">
                <%--@elvariable id="createSavingAccountDTO" type="com.se2.bankingsystem.domains.CustomerAccount.sub.SavingAccount.dto.CreateSavingAccountDTO"--%>
                <form:form method="post" modelAttribute="createSavingAccountDTO" cssClass="form-material">
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
                        <form:label cssClass="col-sm-3 col-form-label" path="principal">Principal</form:label>
                        <div class="col-sm-9">
                            <form:input path="principal" type="number" class="form-control"
                                        required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="principal" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="savingDuration">Duration</form:label>
                        <div class="col-sm-9">
                            <form:select path="savingDuration" type="text" class="form-control form-select"
                                         required="required">
                                <c:forEach var="savingDuration" items="${savingDurations}">
                                    <form:option value="${savingDuration}" label="${savingDuration.translation()}"/>
                                </c:forEach>
                            </form:select>
                            <span class="form-bar"></span>
                            <form:errors path="savingDuration" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <fieldset class="form-group row">
                        <form:label cssClass="col-sm-3 col-form-label" path="startDate">Start Date</form:label>
                        <div class="col-sm-9"><form:input path="startDate" type="date" class="form-control"
                                                          required="required"/>
                            <span class="form-bar"></span>
                            <form:errors path="startDate" cssClass="text-warning"/>
                        </div>
                    </fieldset>

                    <br><br>
                    <div class="d-flex justify-content-md-center">
                        <button id="btn-save" type="button" class="btn btn-success" data-toggle="modal" data-target="#modalAdd">Add</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button id="btn-reset" type="button" class="btn btn-danger">Reset</button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/commons/admin/add-confirm.jsp"/>

<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/suffix.jsp"/>