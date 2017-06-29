<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.edu.unoesc.model.Nota"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>


	<%@ include file="/WEB-INF/jsp/componentes/header.jsp"%>
	<form action='<c:url value="/avaliacao/salvar"/>' method="post">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="formularios">
						<div>
							<h1>Avalie seu DUO/COACH</h1>
							<hr class="divider"></hr>
						</div>
						<h3>Nickname</h3>
						<div class="form-group">
							<select name="avaliacao.usuario.codigo" class="form-control"
								style="border-radius: 10px; min-height: 42px">
								<c:forEach var="users" items="${usuarios}">
									<c:choose>
										<c:when
											test="${avaliacao.usuario.codigo != null && avaliacao.usuario.codigo == users.codigo}">
											<option value="${users.codigo}" selected>${users.nickname}</option>
										</c:when>
										<c:otherwise>
											<option value="${users.codigo}">${users.nickname}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<h3>Comentario</h3>
						<div class="form-group">
							<input type="text" name="avaliacao.comentario"
								class="form-control" placeholder="Comentario"
								value="${avaliacao.comentario}" required="required"
								style="border-radius: 10px; min-height: 42px" />
						</div>
						<!-- 			<div class="campos"> -->
						<!-- 				<h3>Comentário</h3> -->
						<!-- 				<input type="text" class="form-control" placeholder="Comentario" -->
						<!-- 					name="comentario" required="required" -->
						<!-- 					style="border-radius: 10px; min-height: 42px"> -->
						<!-- 			</div> -->

						<h3>Nota</h3>
						<div class="form-group">
							<select name="avaliacao.nota.descricao" class="form-control"
								style="border-radius: 10px; min-height: 42px">
								<c:forEach items="<%=Nota.values()%>" var="entry">
									<option value="${entry}" selected>${entry.descricao}</option>
								</c:forEach>
							</select>

							<hr class="divider"></hr>
							<input type="submit" value="Salvar" class="btn btn-block signin"
								style="border-radius: 10px; min-height: 42px" />
						</div>
						<hr class="divider"></hr>
					</div>
				</div>
			</div>
		</div>

	</form>

	<div class="rodape">
		<%@ include file="/WEB-INF/jsp/componentes/footer.jsp"%>
	</div>
</body>
</html>