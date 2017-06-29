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

<br/><a href="${linkTo[CidadeController].listar()}">Lista de Cidades</a>
<br/>
<br/>Cadastro de Cidade
<form action='<c:url value="/cidade/salvar"/>' method="post">
	<br/>Código:<input type="text" name="cidade.codigo" value="${cidade.codigo}"/>
	<br/>Nome:<input type="text" name="cidade.nome" value="${cidade.nome}"/>
	<br/><input type="submit" value="salvar"/>
</form>


</body>
</html>