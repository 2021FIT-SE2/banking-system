<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar header-navbar pcoded-header">
    <div class="navbar-wrapper">
        <div class="navbar-logo">
            <a class="mobile-menu waves-effect waves-light" id="mobile-collapse">
                <i class="ti-menu"></i>
            </a>
            <a href="<c:url value="/"/>">
                <img class="img-fluid" src="<c:url value="resources/img/logo_nav.png"/>"
                     alt="Theme-Logo"/>
            </a>
            <a class="mobile-options waves-effect waves-light">
                <i class="ti-more"></i>
            </a>
        </div>
        <div class="navbar-container container-fluid">
            <ul class="nav-left">
                <li>
                    <div class="sidebar_toggle"><a href="javascript:void(0)"><i class="ti-menu"></i></a></div>
                </li>
                <li>
                    <a onclick="toggleFullScreen()" class="waves-effect waves-light">
                        <i class="ti-fullscreen"></i>
                    </a>
                </li>
            </ul>
            <ul class="nav-right">
                <li class="header-notification">
                    <a class="waves-effect waves-light">
                        <i class="ti-bell"></i>
                        <span class="badge bg-c-red"></span>
                    </a>
                    <ul class="show-notification">
                        <li>
                            <h6>Notifications</h6>
                            <label class="label label-danger">New</label>
                        </li>
                        <li class="waves-effect waves-light">
                            <div class="media">
                                <img class="d-flex align-self-center img-radius"
                                     src="<c:url value="resources/img/avatar-2.jpg" />"
                                     alt="Generic placeholder image">
                                <div class="media-body">
                                    <h5 class="notification-user">Customer:180472192***</h5>
                                    <p class="notification-msg">+100$</p>
                                    <span class="notification-time">30 minutes ago</span>
                                </div>
                            </div>
                        </li>
                        <li class="waves-effect waves-light">
                            <div class="media">
                                <img class="d-flex align-self-center img-radius"
                                     src="<c:url value="resources/img/profile-admin.png" />"
                                     alt="Generic placeholder image">
                                <div class="media-body">
                                    <h5 class="notification-user">Customer: 7243932993***</h5>
                                    <p class="notification-msg">+2000$</p>
                                    <span class="notification-time">38 minutes ago</span>
                                </div>
                            </div>
                        </li>
                        <li class="waves-effect waves-light">
                            <div class="media">
                                <img class="d-flex align-self-center img-radius"
                                     src="<c:url value="resources/img/avatar-3.jpg" />"
                                     alt="Generic placeholder image">
                                <div class="media-body">
                                    <h5 class="notification-user">Customer: 350959393***</h5>
                                    <p class="notification-msg">+150$</p>
                                    <span class="notification-time">40 minutes ago</span>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="user-profile header-notification">
                    <a class="waves-effect waves-light">
                        <img src="<c:url value="resources/img/${gender == 'MALE' ? 'profile-male' : 'profile-female'}.png" />" class="img-radius"
                             alt="User-Profile-Image">
                        <span>${pageContext.request.userPrincipal.name}</span>
                        <i class="ti-angle-down"></i>
                    </a>
                    <ul class="show-notification profile-notification">
                        <li class="waves-effect waves-light">
                            <a href="<c:url value="/me/profile" />">
                                <i class="ti-user"></i> Profile
                            </a>
                        </li>
                        <li class="waves-effect waves-light">
                            <a href="email-inbox.html">
                                <i class="ti-email"></i> My Messages
                            </a>
                        </li>

                        <li class="waves-effect waves-light">
                            <a href="<c:url value="/logout" />">
                                <i class="ti-layout-sidebar-left"></i> Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

