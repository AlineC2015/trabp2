<%@page import="br.com.alicostacurso.entidades.Usuario"%>
<%@page import="br.com.alicostacurso.jdbc.UsuarioDAO" %>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>
</head>

<body>
	
	<table>
	
	<%
	UsuarioDAO dao = new UsuarioDAO();
    List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
	for (Usuario uDao : lista)
	{
	%>	
	<tr>
		<td><% out.print(uDao.getCod()); %></td>
		<td><%= uDao.getNome() %></td>
		<td><%= uDao.getLogin() %></td>
		<td><%= uDao.getSenha() %></td>
	</tr>
	<%
	}
	%>
	
	</table>	

</body>
</html>