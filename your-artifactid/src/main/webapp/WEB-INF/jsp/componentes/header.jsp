<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/js/bootstrap.js"/>" rel="stylesheet">
<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/css/geral.css"/>" rel="stylesheet">
<link href="<c:url value="/js/jquery.js"/>" rel="stylesheet">
<link href="<c:url value="/img/img.css"/>" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoL Duo</title>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<nav id="header"
		class="navbar navbar-inverse navbar-fixed-top navbar-toggleable-md"
		role="navigation"
		style="background: -webkit-gradient(linear, 0% 0%, 100% 0%, from(rgb(27, 114, 102)), to(rgb(6, 179, 156)));">
		<div class="container">
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="#">DUO</a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav ">
					<li><a href="${linkTo[UsuarioController].listar()}">Buscar
							Duo</a></li>
					<li><a href="${linkTo[UsuarioController].listar2()}">Buscar
							Mentor</a></li>
					<li><a href="${linkTo[AvaliacaoController].listar()}">Avaliar</a></li>
				</ul>
				<%-- 		<c:set var="nickname" value="login.nickname" /> --%>
				<%-- 		<c:out value="${login.nickname}" /> --%>
			</div>
		</div>

	</nav>
</body>
</html>