<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/client.css" type="text/css">
<title>Article</title>
</head>
<body>
	
	<s:form method="post" action="updateClient" theme="css_xhtml">
		<s:textfield label="Nom" name="clientUpdate.nom" labelposition="left" />
		<s:textfield label="Prenom" name="clientUpdate.prenom" required="true"
			labelposition="left" />
		<s:textfield label="Date" name="clientUpdate.date" labelposition="left"
			readonly="true" value="" />
		<s:textfield label="Rue" name="clientUpdate.adresse.rue" required="true"
			labelposition="left" />
		<s:textfield label="Code postal" name="clientUpdate.adresse.codePostal"
			required="true" labelposition="left" />
		<s:textfield label="Ville" name="clientUpdate.adresse.ville" required="true"
			labelposition="left" />
		<s:radio label="Carte de fidélité" labelposition="left"
			id="radiobutton" name="carte_fidelite"
			list="#{'true' : 'oui', 'false' : 'non'}" value="false"/>
		<s:submit label="Enregistrer" />
	</s:form>
	
</body>
</html>