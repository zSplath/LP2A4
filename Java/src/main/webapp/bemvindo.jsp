<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeira página JSP</title>
</head>
<body>
	<%-- Primeira página JSP --%>
	
	<% String mensagem = "Bem vindo à atividade de Java Web de LP2A4"; %>
	<% out.println(mensagem); %>
	<br>
	<% String desenvolvido = "Desenvolvido por Danilo Lessa"; %>
	<%= desenvolvido %>
	<br>
	<% System.out.println("Tudo foi executado!"); %>
</body>
</html>