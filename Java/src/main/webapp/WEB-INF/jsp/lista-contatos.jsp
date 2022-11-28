<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listando contatos com Taglib</title>
</head>
<body >
<c:import url="cabecalho.jsp"/>

<table border="1">
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>
	<c:forEach var="contato" items="${contatos}" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
			<td>${contato.nome}</td>
			<td>
				<c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>
				<c:if test="${empty contato.email}">
					E-mail não informado
				</c:if>
			</td>
			<td>${contato.endereco}</td>
			<td>
			<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
			</td>
			<td>
				<a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a>
			</td>
		</tr>
	</c:forEach>
</table>
	
	<c:import url="rodape.jsp"/>
</body>
</html>