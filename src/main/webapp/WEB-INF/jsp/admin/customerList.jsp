<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%! int fontSize = 1; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cute Banking System</title>

    <!-- Bootstrap core CSS -->
        <script src="<c:url value="/webjars/jquery/3.6.0/jquery.min.js"/>"></script>
        <script src="<c:url value="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value="/webjars/bootstrap/4.6.0/css/bootstrap.min.css"/>"/>
        <!-- Custom styles for this page -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
</head>
<body>
<%while ( fontSize <= 10){ %>
<span style="color: green; font-size: <%= fontSize * 10 %>px;>">
    JSP Edit Customer
</span><br/>
<%fontSize++;%>
<%}%>
</body>
</html>