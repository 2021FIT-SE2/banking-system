<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}" />

<nav class="nav nav-pills nav-fill">
  <a class="nav-item nav-link${param.activeTab.equals("all") ? " active" : ""}" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transactions" />">All Transactions</a>
  <a class="nav-item nav-link${param.activeTab.equals("charge") ? " active" : ""}" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/chargeTransactions" />">Charge</a>
  <a class="nav-item nav-link${param.activeTab.equals("transfer") ? " active" : ""}" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/transferTransactions" />">Transfer</a>
  <a class="nav-item nav-link${param.activeTab.equals("withdraw") ? " active" : ""}" href="<c:url value="/${authority == 'ADMIN' ? 'admin' : 'me'}/withdrawTransactions" />">Withdraw</a>
</nav>
