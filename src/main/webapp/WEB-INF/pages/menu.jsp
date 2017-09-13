<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/menu.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>

<body>
	<h1>Bienvenue sur l'application Luna</h1>
	<div class="container">
		<div class="divCli">
			<s:form method="post" action="client">
				<s:submit cssClass="bouttonClient" name="Valider" value=" " />
			</s:form>
		</div>
		<div class="divMid">
			<s:form method="post" action="commande">
				<s:submit cssClass="bouttonCommande" name="Valider" value=" " />
			</s:form>
			<div class="divArt">
				<s:form method="post" action="article">
					<s:submit cssClass="bouttonArticle" name="Valider" value=" " />
				</s:form>
			</div>
		</div>
		<div class="divCli">
			<s:form method="post" action="stats">
				<s:submit cssClass="bouttonStats" name="Valider" value=" " />
			</s:form>
		</div>
	</div>
	<center>
		<div class="deco">
			<s:form method="post" action="/j_spring_security_logout">
				<s:submit cssClass="btnDeco" value="Déconnexion"/>
			</s:form>
		</div>
	</center>
</body>
</html>