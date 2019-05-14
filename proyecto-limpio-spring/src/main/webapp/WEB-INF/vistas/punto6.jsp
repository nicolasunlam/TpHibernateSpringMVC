<%@page import="org.hibernate.result.Output"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Taller Web 1 - Trabajo Practico</title>
</head>
<body>
 		 <h4>Taller Web 1 - Trabajo Práctico</h4>
 			<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="mostrarPunto" method="POST" modelAttribute="punto6">
			    	<h3 class="form-signin-heading">Taller Web I</h3>
					<hr class="colorgraph"><br>

					Operacion:<form:input path="operacion" id="operacion" type="text" class="form-control" />
					Cadena:<form:input path="cadena" id="cadena" type="text" class="form-control" />
					<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Realizar</button>
				</form:form>

				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
		        </div>
		        </div>
</body>
</html>

