<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="pcoded-navbar">
    <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
    <div class="pcoded-inner-navbar main-menu">
        <div class="">
            <div class="main-menu-header">
                <img class="img-80 img-radius" src="<c:url value="resources/img/profile-admin.png" />"
                     alt="User-Profile-Image">
                <div class="user-details">
                    <span id="more-details">${pageContext.request.userPrincipal.name}<i
                            class="fa fa-caret-down"></i></span>
                </div>
            </div>
            <div class="main-menu-content">
                <ul>
                    <li class="more-details">
                        <a href="<c:url value="/admin/profile" />"><i class="ti-user"></i>View Profile</a>
                        <a href="<c:url value="/admin/settings" />"><i class="ti-settings"></i>Settings</a>
                        <a href="<c:url value="/logout" />"><i class="ti-layout-sidebar-left"></i>Logout</a>
                    </li>
                </ul>
            </div>
        </div>

        <ul class="pcoded-item pcoded-left-item">
            <li class="${param.activeSidebarElementID == "dashboard" ? " active" : ""}">
                <a href="<c:url value="/admin/dashboard"/>" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                    <span class="pcoded-mtext">Dashboard</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
        </ul>
        <%--        <div class="pcoded-navigation-label">Customer</div>--%>
        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu${param.activeSidebarElementID.startsWith("customer-") ? " active" : ""}">
                <a href="<c:url value="/admin/customers"/>" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i><b>BC</b></span>
                    <span class="pcoded-mtext">Manage Customers</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
        </ul>

        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu${param.activeSidebarElementID.toLowerCase().contains("account") ? " active" : ""}">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i><b>BC</b></span>
                    <span class="pcoded-mtext">Manage Accounts</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu expand">
                    <li class="${param.activeSidebarElementID.equals("customerAccount-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/customerAccounts"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">All Customer Accounts</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="${param.activeSidebarElementID.equals("loanAccount-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/loanAccounts"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Loan Accounts</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="${param.activeSidebarElementID.equals("normalAccount-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/normalAccounts"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Normal Accounts</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="${param.activeSidebarElementID.equals("savingAccount-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/savingAccounts"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Saving Accounts</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <%--        <div class="pcoded-navigation-label">Transaction</div>--%>

        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu${param.activeSidebarElementID.toLowerCase().contains("transaction") ? " active" : ""}">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i><b>BC</b></span>
                    <span class="pcoded-mtext">Manage Transactions</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu expand">
                    <li class="${param.activeSidebarElementID.equals("transaction-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/transactions"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">All Transactions</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="${param.activeSidebarElementID.equals("chargeTransaction-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/chargeTransactions"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Charge Transactions</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="${param.activeSidebarElementID.equals("transferTransaction-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/transferTransactions"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Transfer Transactions</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="${param.activeSidebarElementID.equals("withdrawTransaction-list") ? "active" : ""}">
                        <a href="<c:url value="/admin/withdrawTransactions"/>" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext">Withdraw Transactions</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
