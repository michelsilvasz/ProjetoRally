<?xml version="1.0" encoding="ISO-8859-1" ?>
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
<link rel= "stylesheet" type = "text/css" href = "layout.css"/>
<meta/>
</head>
<body>
	
  <div id= "principal">
 
    <div id= "center1">
    
     <table align="center" border="1"  cellspacing="5px"  width="100%">
            
            <h1>Corrida Rally</h1>
                
        <%
        	try {
                CorridaDAO cd = new CorridaDAO();
                 List<DadosCorrida> l = cd.lista();
				for (DadosCorrida v1 : l ) {
				
		%>
		
		<table align= "center" border= "1"  cellspacing= "5px"  width= "100%">
		 <tr>
                 <td>Nº de curva:</td>
                <td>Piloto</td>
                <td>Velocidade Curva em segundos</td>
                 <td>Tempo curva em Km/H</td>
            </tr> 
              
              <tr>
                <td><%= v1.getVolta() %></td>
                 <td><%= v1.getPiloto() %></td>
                 <td><%= v1.getVelocidaC() %></td>
                 <td><%= v1.getTempcurva() %></td>
            </tr>
            <br></br>
            </table>
        <%
				} } catch (Exception e) {
					
				} finally {
					}
				
		%>   
		
		
		  <h1>COLOCAÇÂO</h1>  
           
     <% 
     try {   
     CorridaDAO cd = new CorridaDAO();
     	List<DadosCorrida> l = cd.lista1();
     	for (DadosCorrida v1 : l ) {
            %>
              <table align= "center" border= "1"  cellspacing= "5px"  width= "100%">
		 <tr>
                 <td>Colocação:</td>
                
            </tr> 
              
              <tr>
                <td><%= v1.getMensagem() %></td>
                 
            </tr>
            <br></br>
            </table>
              
              
              <% } } catch (Exception e) {
					
				} finally {
					} %>          
    </div>
     
    
    </div>
</body>
</html>