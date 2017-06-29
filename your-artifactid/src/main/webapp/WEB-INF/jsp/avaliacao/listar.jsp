<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.edu.unoesc.model.Elo"%>
<%@page import="br.edu.unoesc.model.Rota"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/jsp/componentes/header.jsp"%>


	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div>
					<div>
						<h1>Avaliação</h1>

						<hr class="divider"></hr>
					</div>
					<div>
						<a type="submit" class="btn btn-primary btn-block adiciona"
							href="${linkTo[AvaliacaoController].formulario}" />Adicionar</a>

					</div>
					<hr class="divider"></hr>
				</div>



				<table class="table table-bordered table-responsive">
					<thead>
						<tr class="well">
							<th>Código</th>
							<th>Nickname</th>
							<th>Nota</th>
							<th>Comentario</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
					<c:forEach var="p" items="${resultado}">
						<tr>
							<td><c:out value="${p.codigo}" /></td>
							<td><c:out value="${p.usuario.nickname}" /></td>
							<td><c:out value="${p.nota.descricao}" /></td>
							<td><c:out value="${p.comentario}" /></td>
						</tr>
					</c:forEach>
				</table>

				<hr class="divider"></hr>
			</div>
		</div>
	</div>



	<div class="rodape">
		<%@ include file="/WEB-INF/jsp/componentes/footer.jsp"%>
	</div>
</body>
</html>