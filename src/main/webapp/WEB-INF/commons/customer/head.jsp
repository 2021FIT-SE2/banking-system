<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="baseURL"
       value="${pageContext.request.requestURL.substring(0, pageContext.request.requestURL.length() - pageContext.request.requestURI.length())}${pageContext.request.contextPath}/"/>

<!doctype html>
<html lang="en">
<head>
    <base href="${baseURL}">
    <meta charset="ISO-8859-1">
    <title>${param.title != null ? param.title.concat(" | ") : ""}Cute Banking System</title>

    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700,800,900&display=swap"
          rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico"/>">
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/pages/waves/css/waves.min.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/customer/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/pages/waves/css/waves.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/icon/themify-icons/themify-icons.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/icon/icofont/css/icofont.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/customer/jquery.mCustomScrollbar.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/customer/jquery.mCustomScrollbar.css"/>">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/customer/style.css"/>">
</head>
<body>