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
		<div class="titre">
			<h1>Ajouter une commande</h1>
		</div>
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
		</div>
		<div class="articlee">
			<div class="updategauche">
				<div class="articles">
					<s:form cssClass="ajoutArticle" method="post" action="createCommandeArticle" theme="css_xhtml">
						<s:select label="Article" labelposition="left" cssClass="createArticleChamp" name="codeArt" list="listArticles" listValue="designation" listKey="code"></s:select>
						<s:textfield cssClass="quantite" type="number" min="1" max="10" name="quantite" label="Quantité" labelposition="left"/>
						<s:submit cssClass="bouttonArt" name="Chercher" value="Ajouter"/>
					</s:form>
				</div>
				
			</div>
			<div class="updatecenter">
				
					<table>
					<tr class="entete">
						<td class="lefttab">Nom de l'article</td>
						<td>Quantité</td>
						<td>Prix Unitaire</td>
						<td>Prix total</td>
						<td>Supprimer</td>
					</tr>
					<c:forEach  items="${listArticlesCommandes}" var="articles" varStatus="loop">
			   			<tr>
			   				<td> ${articles.designation}</td>
							<td> ${articles.quantite}</td>
							<td> ${articles.prixUnitaire}</td>
							<td> ${articles.prixUnitaire * articles.quantite}</td>
							<td> 
								<s:a action="deleteArticleCommande">
									<img alt="" src="${pageContext.request.contextPath}/css/img/Garbage-Open-48.png" width="30px"><s:param name="codeArt">${loop.index}</s:param>
								</s:a>
							</td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
		
		<div>
			<s:form method="post" action="createUneCommande" theme="css_xhtml">
				<s:select label="Client" labelposition="left" cssClass="createArticleChamp" name="idCli" list="listClients" listValue="nom" listKey="code"></s:select>
				<s:select label="Mode de reglements" labelposition="left" cssClass="createArticleChamp" name="codeReg" list="listModes" listValue="type" listKey="code"></s:select>
				<s:submit cssClass="bouttonArt" name="Chercher" value="Valider la commande"/>
			</s:form>
		</div>
			
	</div>
</body>
</html>