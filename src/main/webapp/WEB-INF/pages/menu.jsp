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
	<s:form method="post" action="client">
		<s:submit cssClass="bouttonClient" name="Valider" value="Client" />
	</s:form>
	<s:form method="post" action="commande">
		<s:submit cssClass="bouttonCommande" name="Valider" value="Commande" />
	</s:form>
	<s:form method="post" action="article">
		<s:submit cssClass="bouttonArticle" name="Valider" value="Article" />
	</s:form>
	<s:form method="post" action="stats">
		<s:submit cssClass="bouttonStats" name="Valider" value="Stats" />
	</s:form>
</body>
</html>