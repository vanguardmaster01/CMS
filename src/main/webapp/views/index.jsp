<%@ page import="com.cms.util.Constants"%>
<%@ page import="com.cms.util.WebUrl"%>
<%@ page import="com.cms.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	User loginuser = (User) session.getAttribute("user");
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="robots" content="noindex, follow">
	<title>Home || CMS</title>
	<!-- Favicon -->
	<link rel="icon" href="/public/web/images/favicon.jpg">

	<!-- Bootstrap CSS -->
	<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />  
	<link href="https://fonts.googleapis.com/css2?family=Poiret+One&display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css2?family=Lato:ital@1&display=swap" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="/public/web/fonts/fonts.css" />-->

	<link rel="preload" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" as="style" onload="this.rel='stylesheet'">
      <noscript><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"></noscript>
    <link rel="preload" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" as="style" onload="this.rel='stylesheet'">
      <noscript><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"></noscript>
       <link rel="preload" href="https://fonts.googleapis.com/css2?family=Poiret+One&display=swap" as="style" onload="this.rel='stylesheet'">
      <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poiret+One&display=swap"></noscript>
	<link rel="preload" href="https://fonts.googleapis.com/css2?family=Lato:ital@1&display=swap" as="style" onload="this.rel='stylesheet'">
      <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato:ital@1&display=swap"></noscript>
		
	
	<!-- Sweet Alert -->
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css'>

</head>
<body>
	<!-- Header File Include -->
	
	<jsp:include page="layout/header.jsp"></jsp:include>
	
	<h1>Welcome to visit our site</h1>
     
	<!-- Footer File Include -->
	<jsp:include page="layout/footer.jsp"></jsp:include>

	<!-- JavaScript -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" async></script>
	<!-- <script src="public/web/js/new-custom.js"></script>
	<script src="public/web/js/aklocation.js"></script> -->
	<!-- Sweet Alert -->
	<script src='https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js' async></script>
	<script type="text/javascript">
	$(document).ready(function (){
		console.log('Hello!');
	});

	</script>

	
</body>
</html>