<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<nav class="nav nav-pills nav-fill">
    <a class="nav-item nav-link${param.activeTab.equals("all") ? " active" : ""}"
       href="<c:url value="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}" />">All Customer
        Accounts</a>
    <a class="nav-item nav-link${param.activeTab.equals("normal") ? " active" : ""}"
       href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/normalAccounts" />">Normal Accounts</a>
    <a class="nav-item nav-link${param.activeTab.equals("loan") ? " active" : ""}"
       href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/loanAccounts" />">Loan Accounts</a>
    <a class="nav-item nav-link${param.activeTab.equals("saving") ? " active" : ""}"
       href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/savingAccounts" />">Saving Accounts</a>
</nav>
