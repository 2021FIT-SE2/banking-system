<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Customer Details"/>

    <jsp:param name="parentLinkText" value="Manage Customer"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers"/>

    <jsp:param name="childLinkText" value="Details"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin' : 'me'}/customers/${customer.id}"/>

    <jsp:param name="activeSidebarElementID" value="add-customer"/>
</jsp:include>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin/customerDetails.css"/>">

<!-- START HERE -->
<div class="container">
    <%@ taglib prefix="customer" tagdir="/WEB-INF/tags/customer" %>
    <customer:basicInfo customer="${customer}"/>

    <c:if test="${customerAccountList != null}">
        <%@ taglib prefix="account" tagdir="/WEB-INF/tags/account" %>
        <%--@elvariable id="customerAccountList" type="java.util.List<com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount>"--%>
        <account:table customerAccountList="${customerAccountList}"/>
    </c:if>

    <c:if test="${transactionList != null}">
        <%@ taglib prefix="transaction" tagdir="/WEB-INF/tags/transaction" %>
        <%--@elvariable id="transactionList" type="java.util.List<com.se2.bankingsystem.domains.Transaction.entity.Transaction>"--%>
        <transaction:table transactionList="${transactionList}"/>
    </c:if>

</div>
<!-- END HERE -->
<jsp:include page="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}/suffix.jsp"/>