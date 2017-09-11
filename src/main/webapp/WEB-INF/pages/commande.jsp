<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/commande.css" type="text/css">
<title>Commande</title>
</head>
<body>
	
	
	<div class="tous">
		<div class="dd">
			<s:form cssClass="boutton" method="post" action="menu" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Menu"/>
			</s:form>
			<s:form method="post" action="client" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Client"/>
			</s:form>
			<s:form method="post" action="article" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Article"/>
			</s:form>
			<s:form method="post" action="commande" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Commande"/>
			</s:form>
			<s:form method="post" action="stats" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Statistique" />
			</s:form>
		</div>
		<div class="article">
			<div class="panelgauche">
				<div class="search">
					<s:form cssClass="searchc" method="post" action="searchCommande" theme="css_xhtml">
						<s:textfield cssClass="searchField" type="text" name="idCli" placeholder="Rechercher"/>
						<s:submit cssClass="searchButon" name="Chercher" value=" "/>
					</s:form>
				</div>
				
				<div class="search">
					<s:a cssClass="textAdd" action="createCommandePage">
						Ajouter une commande
					</s:a>
				</div>
			
			
			</div>
			<div class="fff">
				<table>
					<tr class="entete">
						<td class="lefttab">Code</td>
						<td>Date</td>
						<td>Nom client</td>
						<td>Mode de réglement</td>
						<td>Supprimer</td>
						<td class="righttab">Modifier</td>
					</tr>
					<c:forEach  items="${listCommandes}" var="commande">
			   			<tr>
			   				<td> ${commande.code}</td>
							<td> ${commande.date}</td>
							<td> ${commande.client.nom}</td>
							<td> ${commande.modeReglement.type}</td>
							<td> 
								<s:a action="deleteCommande">
									<img alt="" src="${pageContext.request.contextPath}/css/img/Garbage-Open-48.png" width="30px"><s:param name="codeCom">${commande.code}</s:param>
								</s:a>
							</td>
							<td> 
								<s:a action="updateCommandePage">
									<img alt="" src="${pageContext.request.contextPath}/css/img/Data-Edit-48.png" width="30px">
									<s:param name="codeCom">${commande.code}</s:param>
									<s:param name="idCli">${commande.client.code}</s:param>
									<s:param name="codeReg">${commande.modeReglement.code}</s:param>
								</s:a>
							</td>
						</tr>
					</c:forEach>
				</table>
				</div>
			</div>
	</div>
</body>
</html>