<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">

<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/js/bootstrap.js"/>" rel="stylesheet">
<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/css/geral.css"/>" rel="stylesheet">
<link href="<c:url value="/js/jquery.js"/>" rel="stylesheet">
<link href="<c:url value="/img/img.css"/>" rel="stylesheet">

</head>

<body id="body"
	style="background: -webkit-gradient(linear, 0% 0%, 100% 0%, from(rgb(27, 114, 102)), to(rgb(6, 179, 156))); zoom: 1;">

	<form action="${linkTo[LoginController].index}" method="get">
		<div class="form">

			<div class="title">
				<h3>Entrar</h3>
			</div>

			<div class="login">
				<span class="fa fa-search"></span> <input type="text"
					class="form-control" placeholder="Usuário" name="nickname"
					required="required" style="border-radius: 10px; min-height: 42px">
			</div>
			<div class="senha">
				<input type="password" class="form-control" placeholder="Senha"
					name="senha" required="required" style="border-radius: 10px; min-height: 42px">
			</div>

			<div class="row top-buffer">
				<div class="col-md-4 col-md-offset-8">
					<button type="submit" class="btn btn-block signin" style="border-radius: 10px; min-height: 42px">
						Acessar</button>
				</div>
			</div>

			<div class="cadastrese">
				<br />
				<a href="${linkTo[UsuarioController].formulario()}">Ainda Não é
					Usuário? Cadastre-se</a>
			</div>
		</div>
	</form>

	<div class="img">
		<img class="img-responsive" src="img/duo_logo.png" alt="">
	</div>

</body>
</html>
