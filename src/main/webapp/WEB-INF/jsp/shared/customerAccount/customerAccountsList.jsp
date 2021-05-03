<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="authority" value="${pageContext.request.userPrincipal.authorities[0].name}"/>

<c:set var="commonPrefix" value="/WEB-INF/commons/${authority == 'ADMIN' ? 'admin' : 'customer'}"/>

<jsp:include page="${commonPrefix}/prefix.jsp">

    <jsp:param name="title" value="Account"/>

    <jsp:param name="parentLinkText" value="Manage Account"/>
    <jsp:param name="parentLinkUrl" value="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}"/>

    <jsp:param name="childLinkText" value="List"/>
    <jsp:param name="childLinkUrl" value="/${authority == 'ADMIN' ? 'admin/customerAccounts' : 'me/accounts'}"/>

    <jsp:param name="activeSidebarElementID" value="customerAccount-list"/>
</jsp:include>

<!-- START HERE -->

<jsp:include page="nav-tab.jsp">
    <jsp:param name="activeTab" value="all"/>
</jsp:include>

<%@ taglib prefix="account" tagdir="/WEB-INF/tags/account" %>
<%--@elvariable id="customerAccountList" type="java.util.List<com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount>"--%>
<account:table customerAccountList="${customerAccountList}"/>

<!-- END HERE -->
<jsp:include page="${commonPrefix}/suffix.jsp"/>