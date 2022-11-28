<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tarefa finalizada</title>
<link type="text/css" href="/css/tarefas.css" rel="stylesheet" />
</head>
<body>
	<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
	<script type="text/javascript">
    function finalizaAgora(id) {
      $.post("finalizaTarefa", {'id' : id}, function(resposta) {
        $("#tarefa_"+id).html("Finalizado");
        $("#tarefa_data_"+id).html(resposta);
      });
    }
  </script>
</body>
</html>