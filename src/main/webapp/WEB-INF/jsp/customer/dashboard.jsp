<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/commons/customer/prefix.jsp">

    <jsp:param name="title" value="Dashboard"/>

    <jsp:param name="parentLinkText" value="Me"/>
    <jsp:param name="parentLinkUrl" value="/me/dashboard"/>

    <jsp:param name="childLinkText" value="Dashboard"/>
    <jsp:param name="childLinkUrl" value="/me/dashboard"/>

    <jsp:param name="activeSidebarElementID" value="dashboard"/>
</jsp:include>

    <div id="main">

        <!-- ======= Services Section ======= -->
        <div class="services">
            <div class="container">

                <div class="row">
                    <div class="col-md-4 " data-aos="fade-up">
                        <div class="icon-box icon-box-pink">
                            <div class="icon"><i class="bx bxl-dribbble"></i></div>
                            <h4 class="title"><a href="">Normal Account</a></h4>
                            <p class="description">Link to a CodersBank bank card<br>
                                Make transactions quickly and accurately<br>
                                Transfer money 24/7<br>
                                Withdraw/ deposit money to other accounts<br>
                                Secure customer information, amount of money, and transaction history absolutely</p>
                        </div>
                    </div>

                    <div class="col-md-4 " data-aos="fade-up" data-aos-delay="200">
                        <div class="icon-box icon-box-blue">
                            <div class="icon"><i class="bx bx-dollar-circle"></i></div>
                            <h4 class="title"><a href="">Savings Account</a></h4>
                            <p class="description">Quickly create a savings account<br>
                                Instant Approval<br>
                                High interest rates<br>
                                Safe avenue for funds<br>
                                Easily add money to your savings account<br>
                                Conveniently track savings accounts</p>
                        </div>
                    </div>

                    <div class="col-md-4 " data-aos="fade-up" data-aos-delay="200">
                        <div class="icon-box icon-box-green">
                            <div class="icon"><i class="bx bx-money"></i></div>
                            <h4 class="title"><a href="">Loan Account</a></h4>
                            <p class="description">Quickly create a loan<br>
                                Lots of options for loan terms<br>
                                Instant Approval<br>
                                No Collateral Required<br>
                                Easy online loan status tracking<br>
                                Easy loan payments

                            </p>
                        </div>
                    </div>

                </div>
            </div><!-- End Services Section -->

            <!-- ======= Features Section ======= -->
            <section class="features">
                <div class="container">
                    <div class="section-title">
                        <h2>Features</h2>
                        <p>CodersBank is proud to be the most trusted bank in Vietnam, with millions of users using the
                            Coders banking website, and thousands of transactions are made per day.
                            All services provided are aimed at giving customers the best experience.
                            Users only take a few minutes to register an account. Customers can make online transactions
                            anytime, anywhere, saving time and effort.
                            Coders Bank always supports customers to create online savings accounts, loan accounts with
                            many incentives ....</p>
                    </div>
                    <br>
                    <div class="row" data-aos="fade-up">
                        <div class="col-md-5">
                            <img src="<c:url value="resources/img/dashboard/features-1.svg" />"
                                 alt="user image"
                                 class="img-fluid">
                            <%--                    <img src="assets/img/features-1.svg" class="img-fluid" alt="">--%>
                        </div>
                        <div class="col-md-7 pt-5 order-2 order-md-1">
                            <h3>Coders Bank supports customers to create three types of customer accounts: Normal
                                Account, Savings Account, Loan Account.</h3>
                            <p>Create and manage all types of accounts simply and fast:</p>
                            <ol>
                                <li><strong>1.</strong> Customers go to profile to get customer's id that the Coders Bank system provided
                                </li>
                                <li><strong>2.</strong> Select "All Customer Accounts" in the "Manage Accounts" dropdown menu</li>
                                <li><strong>3.</strong> Click "Create new" and choose one type of account that you want</li>
                                <li><strong>4.</strong> Enter Customer's id and another information required by the system</li>
                                <li><strong>5.</strong> Click "Add" button.</li>
                            </ol>
                        </div>
                    </div>

                    <div class="row" data-aos="fade-up">
                        <div class="col-md-5 order-1 order-md-2">
                            <img src="<c:url value="resources/img/dashboard/features-2.svg" />"
                                 alt="user image"
                                 class="img-fluid">
                            <%--                    <img src="assets/img/features-2.svg" class="img-fluid" alt="">--%>
                        </div>
                        <div class="col-md-7 pt-5 order-2 order-md-1">
                            <h3>Transfer money, withdraw money 24/7, update balance fluctuations</h3>
                            <p>
                                Customers make transactions anytime, anywhere when there is an internet connection.
                                Manipulation a transaction is very simple.
                                The customer provides exactly the information that the system requires depending on each
                                type of transaction.
                                The system will quickly check the information that the customer entered and make the
                                transaction if no error is detected.
                                The client's account balance will be deducted when the transaction is successful.
                            </p>
                            <p>Coders Bank always has measures to best protect your money, all transactions are
                                processed quickly and accurately.</p>
                        </div>
                    </div>

                    <div class="row" data-aos="fade-up">
                        <div class="col-md-5">
                            <img src="<c:url value="resources/img/dashboard/features-4.svg" />"
                                 alt="user image"
                                 class="img-fluid">
                            <%--                    <img src="assets/img/features-4.svg" class="img-fluid" alt="">--%>
                        </div>
                        <div class="col-md-7 pt-5">
                            <h3>Track and manage of account information, transaction history </h3>
                            <br>
                            <p>All information related to the customer's accounts, transaction history are saved on the
                                system and statistically in tabular form for easy checking by the customer.
                                Customers click on the "Manage Transactions" tab in the dashboard and select the
                                transaction type to see a list of transactions made with the account and
                                click "Manage Accounts" tab to check the information of the created account.
                            </p>
                            <p>CodersBank makes sure that all customer data is fully updated and completely
                                confidential. Customers are completely assured and confident when using the CodersBank
                                website.</p>
                        </div>
                    </div>

                    <div class="row" data-aos="fade-up">
                        <div class="col-md-5 order-1 order-md-2">
                            <img src="<c:url value="resources/img/dashboard/features-3.svg" />"
                                 alt="user image"
                                 class="img-fluid">
                            <%--                    <img src="assets/img/features-3.svg" class="img-fluid" alt="">--%>
                        </div>
                        <div class="col-md-7 pt-5 order-2 order-md-1">
                            <h3>Frequently Asked Questions</h3>
                            <h6>Everything you need to know about CodersBank</h6>
                            <br>
                            <div class="container">
                                <ol>
                                    <li class="1" data-toggle="collapse" data-target="#q1"><strong>1.</strong> What is CodersBanking
                                        service?
                                    </li>
                                    <div id="q1" class="collapse">
                                        CodersBanking service is a banking service on website provided by Coders to
                                        individuals to support the implementation of finacial transactions, non-finacial
                                        transactions and advanced facilities.
                                    </div>

                                    <li class="2" data-toggle="collapse" data-target="#q2"><strong>2.</strong> What are the main features of
                                        CodersBanking service?
                                    </li>
                                    <div id="q2" class="collapse">
                                        CodersBanking service provides the following main features:<br>
                                        -Inquiry on deposit, savings, loan accounts.<br>
                                        -Look up for statements of deposit, savings and loan accounts.<br>
                                        -Money transfer.<br>
                                        -....
                                    </div>

                                    <li class="3" data-toggle="collapse" data-target="#q3"><strong>3.</strong> Who are customers using
                                        CodersBanking website?
                                    </li>
                                    <div id="q3" class="collapse">
                                        CodersBanking service allows all individual customers, including residents and
                                        non-residents, with or without payment accounts at Coders...
                                    </div>

                                    <li class="4" data-toggle="collapse" data-target="#q4"><strong>4.</strong> What is the username to log
                                        into CodersBanking website?
                                    </li>
                                    <div id="q4" class="collapse">
                                        The username to log into the CodersBanking is the name that you register at the
                                        service registration form provided by Coders.
                                    </div>

                                    <li class="5" data-toggle="collapse" data-target="#q5"><strong>5.</strong> How can I view transaction
                                        history on accounts?
                                    </li>
                                    <div id="q5" class="collapse">
                                        You can query transactions history on accounts up to 1 years ago from the
                                        current date.
                                    </div>

                                    <li class="6" data-toggle="collapse" data-target="#q6"><strong>6.</strong> Can I perform interbank money
                                        transfer on CodersBanking on holidays or outside office hours?
                                    </li>
                                    <div id="q6" class="collapse">
                                        You can make Coders external transfer on holidays or outside hours by using the
                                        24/7 fast money transfer to the card/ account numbers of banks participating in
                                        the payment system.
                                    </div>
                                </ol>
                            </div>
                        </div>
                    </div>

                </div>
            </section><!-- End Features Section -->

        </div><!-- End #main -->

    </div><!-- End Footer -->

<!-- ======= Footer ======= -->
<div id="footer" data-aos="fade-up" data-aos-easing="ease-in-out" data-aos-duration="500">

    <div class="footer-newsletter">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h4>CodersBank</h4>
                    <p>Bring the world to your side</p>
                </div>
            </div>
        </div>
    </div>

    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 footer-links">
                    <h4>Our Services</h4>
                    <ul>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Manage Transactions</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Manage Accounts</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Manage Wallets</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Manage Customer's Profile </a></li>

                    </ul>
                </div>

                <div class="col-lg-3 col-md-6 footer-contact">
                    <h4>Contact Us</h4>
                    <p>
                        Km 9, Nguyen Trai <br>
                        Thanh Xuan, Ha Noi<br>
                        Viet Nam <br><br>
                        <strong>Phone:</strong> 0993589899<br>
                        <strong>Email:</strong> codersbank@gmail.com<br>
                    </p>

                </div>

                <div class="col-lg-3 col-md-6 footer-info">
                    <h3>About CodersBank</h3>
                    <p>CodersBank- an e-commerce bank with 10 years of operation, used by millions of customers,
                        promises to bring customers the most satisfaction.</p>
                    <div class="social-links mt-3">
                        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- END HERE -->
    <jsp:include page="/WEB-INF/commons/customer/suffix.jsp"/>
<%--<jsp:include page="${commonPrefix}/suffix.jsp"/>--%>