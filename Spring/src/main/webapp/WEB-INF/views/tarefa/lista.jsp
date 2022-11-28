<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="/css/tarefas.css" rel="stylesheet" />
<title>Criando nova tabela</title>
<script type="text/javascript" src="/js/jquery.js"></script>
</head>
<body>
    <a href="novaTarefa">Criar nova tarefa</a>
    
    <br><br>
    
    <table>
    	<tr>
    		<th>Id</th>
    		<th>Descrição</th>
    		<th>Finalizado?</th>
    		<th>Data de finalização</th>
    	</tr>
      	<c:forEach items="${tarefas}" var="tarefa">
	      	<tr id="tarefa_${tarefa.id}">
		        <td>${tarefa.id}</td>
		        <td>${tarefa.descricao}</td>

	    		<c:if test="${tarefa.finalizado eq true}">
         			 <td>Finalizado</td>
        		</c:if>
        		
		    	<c:if test="${tarefa.finalizado eq false}">
		          <td>
		            <a href="#" onClick="finalizaAgora(${tarefa.id})">
		              Finalizar
		            </a>
		          </td>
		        </c:if>
		    		
	    		<td>
      		    	<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
       			</td>
       			
        		<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
        		<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
        		
	    	</tr>
	    </c:forEach>
    </table>

	<script type="text/javascript">
	function finalizaAgora(id) {
		$.post("finalizaTarefa", {'id' : id}, function(resposta) {
		    $("#tarefa_"+id).html(resposta);
		});
	}
	</script>
</body>
</html>