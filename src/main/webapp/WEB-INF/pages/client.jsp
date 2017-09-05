<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/client.css"
	type="text/css">
<title>Client</title>
</head>
<body>

	<table class="tableP">
		<tr>
			<td>Code</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Date</td>
			<td>Ville</td>
			<td>Supprimer/Modifier</td>
		</tr>
		<c:forEach items="${listClients}" var="client">
			<tr>
				<td>${client.code}</td>
				<td>${client.nom}</td>
				<td>${client.prenom}</td>
				<td>
					<fmt:formatDate value="${client.date}" pattern="yyyy-MM-dd" />
					<c:out value="${parsedDate}" />
				</td>
				<td>${client.adresse.ville}</td>
				<td>
					<s:a action="deleteClient">
								Supprimer<s:param name="codeCli">${client.code}</s:param>
					</s:a> <s:text name=" / " /> <s:a action="updateClientPage">
								Modifier<s:param name="codeCli">${client.code}</s:param>
					</s:a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<s:form cssClass="formulaire" action="createClient" method="post"
		theme="css_xhtml">
		<s:textfield label="Nom" required="true" name="client.nom" labelposition="left" />
		<s:textfield label="Prenom" name="client.prenom" required="true"
			labelposition="left" />
		<s:textfield label="Rue" name="client.adresse.rue" required="true"
			labelposition="left" />
		<s:textfield label="Code postal" name="client.adresse.codePostal"
			required="true" labelposition="left" />
		<s:textfield label="Ville" name="client.adresse.ville" required="true"
			labelposition="left" />
		<s:radio label="Carte de fidélité" labelposition="left"
			id="radiobutton" name="carte_fidelite"
			list="#{'true' : 'oui', 'false' : 'non'}" value="false"/>
		<s:submit label="Enregistrer" />
	</s:form>
</body>
</html>