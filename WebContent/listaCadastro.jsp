<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="autentica.Usuario"%>
<%@page import="autentica.LoginDAO"%>
<%@page import="thread.CorridaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="thread.DadosCorrida"%>
<%@page import="thread.CorridaDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Rally Race Extreme</title>
<link rel="stylesheet" type="text/css" href="estilo1.css"/>
<meta/>
</head>
<body>
	
 
    <aside> <titulo>
				<h1>
					<marquee> <img src="resources/img/bandeira1.png"></img>Resultado... 
					<img src="resources/img/bandeira1.png"></img></marquee>
				</h1>
			</titulo> 
	</aside>

	<fundo_menu_escolha1> 
    
            
            <h1>Dados User</h1>
                
        <%
        	try {
                LoginDAO cd = new LoginDAO();
                 List<Usuario> l = cd.lista();
				for (Usuario v1 : l ) {
				
		%>
		
		
              <b>   <label>Nome:</label> &nbsp; <%=v1.getNome()%></b> <br></br>
              <b>  <label>Data nascimento:</label> &nbsp; <%= v1.getData_ns() %></b> <br></br>
              <b>  <label>Email:</label> &nbsp;  <%= v1.getEmail()%></b> <br></br>
              <b>   <label>Telefone:</label>&nbsp; <%= v1.getTelefone() %></b> <br></br>
            
               
           
        <%
				} } catch (Exception e) {
					
				} finally {
					}
				
		%>   
		
		
		  </fundo_menu_escolha1> 
    
</body>
</html>