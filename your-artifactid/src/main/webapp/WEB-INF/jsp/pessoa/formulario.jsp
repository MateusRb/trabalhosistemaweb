<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<br/><a href="${linkTo[PessoaController].listar()}">Lista de Pessoas</a>
<br/>
<br/>Cadastro de Pessoa
<form action='<c:url value="/pessoa/salvar"/>' method="post">
	<br/>Código:<input type="text" name="pessoa.codigo" value="${pessoa.codigo}"/>
	<br/>Nome:<input type="text" name="pessoa.nome" value="${pessoa.nome}"/>
	<br/>Altura:<input type="text" name="pessoa.altura" value="${pessoa.altura}"/>
	<br/>Cidade:
	<select name="pessoa.cidade.codigo">
		<c:forEach var="cid" items="${cidades}">
			<c:choose>
				<c:when test="${pessoa.cidade.codigo != null && pessoa.cidade.codigo == cid.codigo}">
					<option value="${cid.codigo}" selected >${cid.nome}</option>
				</c:when>
				<c:otherwise>
					<option value="${cid.codigo}">${cid.nome}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>	
	</select>
	<br/><input type="submit" value="salvar"/>
</form>


</body>
</html>