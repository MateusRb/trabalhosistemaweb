<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.edu.unoesc.model.Elo"%>
<%@page import="br.edu.unoesc.model.Rota"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/jsp/componentes/header.jsp"%>


	<form action='<c:url value="/usuario/buscarMentor"/>' method="post"
		class="buscarCombo">

		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

					<h1>Buscar Mentor</h1>
					<div class="campos">
						<br />Elo:<select name="elo" class="form-control">
							<c:forEach items="<%=Elo.values()%>" var="entry">
								<option value="${entry}" selected>${entry.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<div class="campos">
						<br />Rota:<select name="rota" class="form-control">
							<c:forEach items="<%=Rota.values()%>" var="entry">
								<option value="${entry}" selected>${entry.descricao}</option>
							</c:forEach>

						</select>
					</div>
					<br /> <input type="submit" value="Buscar Mentor" class="btn btn-block signin"
						style="border-radius: 10px; min-height: 42px" />

					<hr class="divider"></hr>
				</div>
			</div>
		</div>
	</form>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

				<table class="table table-bordered tabela">
					<thead>
						<tr class="well">
							<th>Código</th>
							<th>Nickname</th>
							<th>Elo</th>
							<th>Rota</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
					<c:forEach var="p" items="${resultado}">
						<tr>
							<td><c:out value="${p.codigo}" /></td>
							<td><c:out value="${p.nickname}" /></td>
							<td><c:out value="${p.elo}" /></td>
							<td><c:out value="${p.rota}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

	<div class="rodape">
		<%@ include file="/WEB-INF/jsp/componentes/footer.jsp"%>
	</div>
</body>
</html>