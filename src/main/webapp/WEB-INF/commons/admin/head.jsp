<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="baseURL" value="${pageContext.request.requestURL.substring(0, pageContext.request.requestURL.length() - pageContext.request.requestURI.length())}${pageContext.request.contextPath}/"/>

<!doctype html>
<html lang="en">
<head>
  <base href="${baseURL}">
  <meta charset="ISO-8859-1">
  <title>Cute Banking System</title>
  <jsp:include page="/WEB-INF/commons/admin/css.jsp"/>
</head>
<body>