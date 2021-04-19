<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="nav nav-pills nav-fill">
  <a class="nav-item nav-link${param.activeTab.equals("all") ? " active" : ""}" href="<c:url value="/admin/transactions" />">All Transactions</a>
  <a class="nav-item nav-link${param.activeTab.equals("charge") ? " active" : ""}" href="<c:url value="/admin/chargeTransactions" />">Charge</a>
  <a class="nav-item nav-link${param.activeTab.equals("transfer") ? " active" : ""}" href="<c:url value="/admin/TransferTransactions" />">Transfer</a>
  <a class="nav-item nav-link${param.activeTab.equals("withdraw") ? " active" : ""}" href="<c:url value="/admin/WithdrawTransactions" />">Withdraw</a>
</nav>
