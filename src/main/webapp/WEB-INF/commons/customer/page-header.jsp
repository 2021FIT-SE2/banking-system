<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
    <div class="page-block">
        <div class="row align-items-center">
            <div class="col-md-8">
                <div class="page-header-title">
                    <h3 class="m-b-10">${param.pageTitle != null ? param.pageTitle : "{Page Title}"}</h3>
                    <%--                                        <p class="m-b-0">Lorem Ipsum is simply dummy text of the printing</p>--%>
                </div>
            </div>
            <div class="col-md-4">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="<c:url value="/"/>"> <i class="fa fa-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item">
                        <a href="<c:url value="${param.parentLinkUrl != null ? param.parentLinkUrl : '/'}" />">${param.parentLinkText != null ? param.parentLinkText : "{Parent Link}"}</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a href="<c:url value="${param.childLinkUrl != null ? param.childLinkUrl : '/'}" />">${param.childLinkText != null ? param.childLinkText : "{Child Link}"}</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>