<jsp:include page="/WEB-INF/commons/customer/head.jsp">
    <jsp:param name="title" value="${param.title}"/>
</jsp:include>
<jsp:include page="/WEB-INF/commons/customer/preload.jsp"/>

<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">
        <jsp:include page="/WEB-INF/commons/customer/horizontal-navbar.jsp"/>

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">

                <jsp:include page="/WEB-INF/commons/customer/vertical-navbar.jsp"/>

                <div class="pcoded-content">

                    <jsp:include page="/WEB-INF/commons/customer/page-header.jsp">
                        <jsp:param name="pageTitle" value="${param.title}"/>
                    </jsp:include>

                    <div class="pcoded-inner-content">
                        <div class="main-body">
                            <div class="page-wrapper">
                                <div class="page-body">
