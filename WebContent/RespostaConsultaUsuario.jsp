<%@page import="autentica.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="autentica.Usuario"%>
<%@ page errorPage="aula5_jsp_erro/paginaErro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setLocale value="pt_BR" />
<link rel="stylesheet" type="text/css" href="estilo1.css"/>
<title><c:out value='${titulo}' /></title>
</head>

<body>

<aside> <titulo>
	<h1>
		<marquee> <img src="resources/img/bandeira1.png"></img>RESPOSTA... 
		<img src="resources/img/bandeira1.png"></img></marquee>
	</h1>
	</titulo> </aside>

	<fundo_menu_escolha1> 
					<c:if test="${usuario != null}">
						<h1 class="nivel-um">
							<c:out value='${titulo}' />
						</h1>
						<fieldset>
							<legend><fmt:message key="carro.legendaparcial"/> <c:out value='${titulo}' /></legend>
							<table>
								<tr>
									<td>Codigo Usuario</td>
									<td><c:out value='${usuario.ID}' /></td>
								</tr>
								<tr>
									<td>Nome</td>
									<td><c:out value='${usuario.NOME}' /></td>
								</tr>
								<tr>
									<td>E-mail</td>
									<td><c:out value='${usuario.EMAIL}' /></td>
								</tr>
								<tr>
									<td>Telefone</td>
									<td><c:out value='${usuario.TELEFONE}' /></td>
								</tr>
							</table>
						</fieldset>
					</c:if>
					<c:if test="${usuario == null}">
						<c:out value="<fmt:message key="geral.alertaDados"/>" />
					</c:if>
					<p>
										<a href="pagina01.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
									</p>
				
				
				
				
				<P>Resultado da Consulta de Municipio</P>
				<table>
					<%Usuario user = (Usuario)request.getAttribute("usuario");
					if(user != null){%>
					     <tr><td>Codigo Usuario: </td><td><%out.println(user.getId());%></td></tr>
						 <tr><td>Nome: </td><td><%out.println(user.getNome());%> </td></tr>
						 <tr><td>E-mail: </td><td><%out.println(user.getEmail());%> </td></tr>
						 <tr><td>Telefone: </td><td><%out.println(user.getTelefone()); %></td></tr>
					<%}%>
				</table>
					<p>
						<a href="pagina01.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
						</p>
	
	
		</fundo_menu_escolha1> 
</body>
</html>