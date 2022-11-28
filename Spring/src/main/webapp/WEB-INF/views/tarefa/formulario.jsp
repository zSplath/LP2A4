<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Tarefas</title>
<link type="text/css" href="/css/tarefas.css" rel="stylesheet" />
</head>
<body>
	<h3>Adicionar tarefas</h3>
	<form action="adicionaTarefa" method="post">
		Descrição: <br>
		<textarea name="descricao" rows="5" cols="100"></textarea><br>
		<form:errors path="tarefa.descricao" cssStyle="color:red"/><br>
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>