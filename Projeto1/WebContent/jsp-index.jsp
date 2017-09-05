<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">

<title>Create Notes</title>

</head>

<body>

<%@ page import="java.util.*,myPackage.*" %>

<table align="center">
<th><form method='post' action="cria">
<label class="labelg">Seu Nome:</label> <br><input type='text' name='nome'><br>
<label class="labelg">Seu Texto:</label> <br><textarea name='text' class="texto"></textarea><br>
<span><input type='submit' value='Criar' class="cria"></span><br>
</form></th>

<th><form method='post' action="remove">
<label class="labelr">ID da Nota: </label><br>
<input type='number' name='id'><br>
<input type='submit' value='Remover' class="remover"><br>
</form></th>

<th><form method='post' action="atualiza">
<label class="labelb">ID da Nota: </label><br><input type='number' name='id'><br>
<label class="labelb">Seu Nome: </label><br><input type='text' name='nome'><br>
<label class="labelb">Novo Texto: </label><br><textarea name='text' class="texto"></textarea><br>
<input type='submit' value='Atualizar' class="att"><br>
</form></th>
</table>
<% DAO dao = new DAO();


 List<Notas> notas = dao.getLista();
 for (Notas nota : notas ) { %>
 
<div class="note">
  <p><strong><%=nota.getId()%>. <%=nota.getNome()%> </strong><br><br> <%=nota.getText()%></p>
</div>
	
 	
<% } %>

</body>
</html>