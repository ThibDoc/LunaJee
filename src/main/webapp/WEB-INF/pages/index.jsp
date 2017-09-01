<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexions</title>
</head>
<body>
	<div class="titre">Luna</div>
	<div class="container">
		<div class="connexion">
			<s:form method="post" action="j_spring_security_check">
				<s:textfield cssClass="textfieldcon" label="Nom d'utilisateur" labelposition="top" type="text" 
					name='username' />
				<s:textfield cssClass="textfieldcon" label="Mot de passe" labelposition="top" type="password"
					name="password" />
				<s:submit name="Valider" value="Connexion" />
			</s:form>
		</div>
	</div>
</body>
</html>