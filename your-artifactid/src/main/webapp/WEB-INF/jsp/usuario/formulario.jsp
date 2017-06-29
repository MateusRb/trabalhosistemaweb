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
	<form action='<c:url value="/usuario/salvar"/>' method="post">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">

					<h1>Cadastro de Usuario</h1>
					<div class="formularios">
						<div class="form-group">
							<h3>Nickname</h3>
							<span class="fa fa-search"></span> <input type="text"
								class="form-control" placeholder="Nickname" name="nickname"
								required="required"
								style="border-radius: 10px; min-height: 42px">
						</div>
						<div class="form-group">
							<h3>Password</h3>
							<input type="password" class="form-control" placeholder="Senha"
								name="senha" required="required"
								style="border-radius: 10px; min-height: 42px">
						</div>
						<h3>Elo</h3>
						<div class="form-group">
							<select name="usuario.elo.descricao" class="form-control"
								style="border-radius: 10px; min-height: 42px">
								<c:forEach items="<%=Elo.values()%>" var="entry">
									<option value="${entry}" selected>${entry.descricao}</option>
								</c:forEach>
							</select>

							<h3>Rota</h3>
							<select name="usuario.rota.descricao" class="form-control"
								style="border-radius: 10px; min-height: 42px">
								<c:forEach items="<%=Rota.values()%>" var="entry">
									<option value="${entry}" selected>${entry.descricao}</option>
								</c:forEach>
							</select>
							<h3></h3>
							<input type="submit" value="Salvar" class="btn btn-block signin"
								style="border-radius: 10px; min-height: 42px" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<%@ include file="/WEB-INF/jsp/componentes/footer.jsp"%>

</body>
</html>