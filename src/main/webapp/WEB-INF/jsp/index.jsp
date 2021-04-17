<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cute Banking System</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700,800,900&display=swap"
          rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css"/>"/>

    <!-- Extended CSS resources -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/elegant-icons.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/flaticon.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/owl.carousel.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/slicknav.min.css"/>">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
    <!-- Custom styles for this page -->
</head>
<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Offcanvas Menu Begin -->
<%--<div class="offcanvas__menu__overlay"></div>--%>
<%--<div class="offcanvas__menu__wrapper">--%>
<%--    <div class="canvas__close">--%>
<%--        <span class="fa fa-times-circle-o"></span>--%>
<%--    </div>--%>
<%--    <div class="offcanvas__logo">--%>
<%--        <a href="#"><img src="<c:url value="resources/img/logo.png"/>" alt=""/></a>--%>
<%--    </div>--%>
<%--    <nav class="offcanvas__menu mobile-menu">--%>
<%--        <ul>--%>
<%--            <li class="active"><a href="./index.html">Home</a></li>--%>
<%--            <li><a href="/admin/dashboard">Admin</a></li>--%>
<%--            <li><a href="./hosting.html">Hosting</a></li>--%>
<%--            <li><a href="#">Pages</a>--%>
<%--                <ul class="dropdown">--%>
<%--                    <li><a href="./pricing.html">Pricing</a></li>--%>
<%--                    <li><a href="./blog-details.html">Blog Details</a></li>--%>
<%--                    <li><a href="./404.html">404</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>
<%--            <li><a href="./blog.html">News</a></li>--%>
<%--            <li><a href="./contact.html">Contact</a></li>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--    <div id="mobile-menu-wrap"></div>--%>
<%--    <div class="offcanvas__auth">--%>
<%--        <ul>--%>
<%--            <li><a href="#"><span class="icon_chat_alt"></span> Live chat</a></li>--%>
<%--            <li><a href="/login"><span class="fa fa-user"></span> Login / Register</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--    <div class="offcanvas__info">--%>
<%--        <ul>--%>
<%--            <li><span class="icon_phone"></span>012345678</li>--%>
<%--            <li><span class="fa fa-envelope"></span>Banking support@gmail.com</li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header-section">
    <div class="header__info">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__info-left">
                        <ul>
                            <li><span class="icon_phone"></span>012345678</li>
                            <li><span class="fa fa-envelope"></span> codersBank@gmail.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__info-right">
                        <ul>
                            <li><a href="#"><span class="icon_chat_alt"></span> Live chat</a></li>
                            <li><a href="/login"><span class="fa fa-user"></span> Login / Register</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="./index.html"><img src="<c:url value="resources/img/codersBank-dark.png"/>" alt=""/></a>
                </div>
            </div>
            <div class="col-lg-9 col-md-9">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="./index.html">Home</a></li>
                        <li><a href="https://portal.vietcombank.com.vn/en-us/news/Pages/home.aspx">News</a></li>
                        <li><a href="https://portal.vietcombank.com.vn/en-us/about/Pages/Home.aspx?devicechannel=default">About us</a></li>
                        <%--                        <li><a href="#">Pages</a>--%>
                        <%--                            <ul class="dropdown">--%>
                        <%--                                <li><a href="./pricing.html">Pricing</a></li>--%>
                        <%--                                <li><a href="./blog-details.html">Blog Details</a></li>--%>
                        <%--                                <li><a href="./404.html">404</a></li>--%>
                        <%--                            </ul>--%>
                        <%--                        </li>--%>
                        <li><a href="#">Help</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="canvas__open">
            <span class="fa fa-bars"></span>
        </div>
    </div>
</header>
<!-- Header End -->

<section class="hero-section">
    <div class="hero__slider owl-carousel">
        <div class="hero__item set-bg" data-setbg="resources/img/hero/hero-1.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="hero__text">
                            <h5>Start managing your money with us</h5>
                            <h2>Welcome to the CodersBank!<br/>Bank System</h2>
                            <a href="#" class="primary-btn">Get started now</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="hero__img">
                            <img src="<c:url value="resources/img/hero/hero-right.png"/>" alt=""/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="hero__item set-bg" data-setbg="resources/img/hero/hero-1.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="hero__text">
                            <h5>We are here to help you</h5>
                            <h2>Save more and <br/>earn more</h2>
                            <a href="#" class="primary-btn">Get started now</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="hero__img">
                            <img src="<c:url value="resources/img/hero/hero-right.png"/>" alt=""/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

<!-- Register Domain Section Begin -->
<section class="register-domain spad">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-8">
                <div class="register__text">
                    <div class="section-title">
                        <h3>What are you interested in?</h3>
                    </div>
                    <h5>Find something here...</h5>
                    <br>
                    <div class="register__form">
                        <form action="#">
                            <input type="text" placeholder="ex: interest rates">
                            <div class="change__extension">
                                Saving account
                                <ul>
                                    <li>Loan</li>
                                </ul>
                            </div>
                            <button type="submit" class="site-btn">Search</button>
                        </form>
                    </div>
                    <div class="register__result">
                        <h3>Savings</h3>
                        <ul>
                            <li>Demand<span>0.10%</span></li>
                            <li>7 days <span>0.20%</span></li>
                            <li>14 days <span>0.20%</span></li>
                            <li>1 months <span>2.9%</span></li>
                            <li>3 months <span>3.2%</span></li>
                            <li>6 months <span>5.5%</span></li>
                            <li>24 months <span>5.3%</span></li>
                            <li>48 months <span>5.3%</span></li>
                            <li>60 months <span>5.3%</span></li>

                        </ul>
                    </div>
                    <p>Save your money to earn more!</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Register Domain Section End -->

<!-- Services Section Begin -->
<section class="services-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h3>Our services</h3>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="services__item">
                    <h5>Advancing of loans</h5>
                    <span>Profit-oriented business organizations.</span>
                    <p>So they have to advance a loan to the public and generate interest from them as profit.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="services__item">
                    <h5>Online banking</h5>
                    <br>
                    <span>Also known as Internet banking</span>
                    <p>A service offered by banks that allows account holders to access their account data via the
                        internet</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="services__item">
                    <h5>Check/Cheque Payment</h5>
                    <span>Provide cheque pads to the account holders</span>
                    <p>CodersBank pays for cheques of customers after formal verification and official procedures.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="services__item">
                    <h5> Home banking</h5>
                    <br>
                    <p>It includes actions such as making account inquiries, transferring money, paying bills, applying
                        for loans, directing deposits.</p>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="services__item">
                    <h5>Priority banking</h5>
                    <br>
                    <span>A number of various services</span>
                    <p>Some of the popular ones include free checking, online bill pay, financial consultation, and
                        information.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="services__item">
                    <h5>Mobile Banking</h5>
                    <span>Also known as M-Banking</span>
                    <p>Performing balance checks, account transactions, payments, credit applications and other banking
                        transactions via a mobile device</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Services Section End -->

<!-- Pricing Section Begin -->
<section class="pricing-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-7">
                <div class="section-title normal-title">
                    <h3>Exchange rates</h3>
                </div>
            </div>
            <div class="col-lg-5 col-md-5">
                <div class="pricing__swipe-btn">
                    <label for="month" class="active">Buying
                        <input type="radio" id="month">
                    </label>
                    <label for="yearly">Selling
                        <input type="radio" id="yearly">
                    </label>
                </div>
            </div>
        </div>
        <div class="row monthly__plans active">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>USD</h4>
                    <h3>22,980.00/<span>23,160.00</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>EUR</h4>
                    <h3>27,046.24/<span>28,174.59</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>GPB</h4>
                    <h3>31,306.84/<span>32,288.33</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>JPY</h4>
                    <h3>208.12/<span>216.80</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>

        <div class="row yearly__plans">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>USD</h4>
                    <h3>22,980.00/<span>23,160.00</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>EUR</h4>
                    <h3>27,046.24/<span>28,174.59</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>GPB</h4>
                    <h3>31,306.84/<span>32,288.33</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="pricing__item">
                    <h4>JPY</h4>
                    <h3>208.12/<span>216.80</span></h3>
                    <a href="#" class="primary-btn">View details</a>
                </div>
            </div>
        </div>
        </div>
    </div>
</section>
<!-- Pricing Section End -->

<!-- Achievement Section Begin -->
<section class="achievement-section set-bg spad" data-setbg="resources/img/achievement-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-6">
                <div class="achievement__item">
                    <span class="fa fa-user-o"></span>
                    <h2 class="achieve-counter">150</h2>
                    <p>Partners</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <div class="achievement__item">
                    <span class="fa fa-edit"></span>
                    <h2 class="achieve-counter">246889</h2>
                    <p>Customers</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <div class="achievement__item">
                    <span class="fa fa-clone"></span>
                    <h2 class="achieve-counter">100</h2>
                    <p>Services</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <div class="achievement__item">
                    <span class="fa fa-cog"></span>
                    <h2 class="achieve-counter">50932832</h2>
                    <p>Visitors</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Achievement Section End -->

<!-- Work Section Begin -->
<section class="work-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h3>Do you know?</h3>
                </div>
                <div class="work__text">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="work__item">
                                <i class="fa fa-desktop"></i>
                                <span>PERSONAL</span>
                                <ul class="footer__text-widget" style="list-style-type: none;">
                                    <li><a href="#">Promotions</a></li>
                                    <li><a href="#">Saving</a></li>
                                    <li><a href="#">Remittence</a></li>
                                    <li><a href="#">Card</a></li>
                                    <li><a href="#">Loan personal</a></li>
                                    <li><a href="#">E-Banking</a></li>
                                </ul>
                                <a href="#" class="primary-btn">Read More</a>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="work__item">
                                <i class="fa fa-shopping-bag"></i>
                                <span>CORPORATE</span>
                                <ul class="footer__text-widget" style="list-style-type: none;">
                                    <li><a href="#">Financial</a></li>
                                    <li><a href="#">Institutions</a></li>
                                    <li><a href="#">Business</a></li>
                                    <li><a href="#">Account SMEs</a></li>
                                    <li><a href="#">Business customers</a></li>
                                </ul>
                                <a href="#" class="primary-btn">Read More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Work Section End -->

<!-- Footer Section Begin -->
<footer class="footer-section">
    <div class="footer__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="footer__top-call">
                        <h5>Need Help? Call us</h5>
                        <h2>+1 175 946 2316 096</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="footer__top-auth">
                        <h5>Join Now And Manage Your Money</h5>
                        <a href="/login" class="primary-btn">Log in</a>
                        <a href="/register" class="primary-btn sign-up">Sign Up</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer__text set-bg" data-setbg="resources/img/footer-bg.png">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="footer__text-about">
                        <div class="footer__logo">
                            <a href="/"><img src="<c:url value="resources/img/codersBank-dark.png"/>" alt=""/></a>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                            ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida viverra maecen
                            lacus vel facilisis. </p>
                        <div class="footer__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-youtube-play"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-3">
                    <div class="footer__text-widget">
                        <h5>Company</h5>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Support</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-3 col-sm-3">
                    <div class="footer__text-widget">
                        <h5>CONTACT US</h5>
                        <ul class="footer__widget-info">
                            <li><span class="fa fa-map-marker"></span> Km9 Nguyen Trai, Nam Tu Niem<br/>
                                Ha Noi, Viet Nam
                            </li>
                            <li><span class="fa fa-mobile"></span> 125-711-811 | 125-668-886</li>
                            <li><span class="fa fa-headphones"></span>codersBank@gmail.com</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer__text-copyright">
                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<script src="<c:url value="/webjars/jquery/3.6.0/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.slicknav.js"/>"></script>
<script src="<c:url value="/resources/js/lib/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/index.js"/>"></script>

<script>
    console.log(firebase.auth().currentUser());
</script>

</body>
</html>