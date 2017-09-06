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
	href="${pageContext.request.contextPath}/css/article.css" type="text/css">
<title>Article</title>
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
		</div>
		<div class="article">
			<div class="updategauche">
				<div class="search">
					<s:form cssClass="searchc" method="post" action="article" theme="css_xhtml">
						<s:textfield cssClass="searchField" type="text" name="search" placeholder="Rechercher"/>
						<s:submit cssClass="searchButon" name="Chercher" value=" "/>
					</s:form>
				</div>
				
				<div class="search">
					<s:a cssClass="textAdd" action="article">
						Ajouter un article
					</s:a>
			</div>
				
			</div>
			<div class="updatecenter">
				<fieldset><legend>Création</legend>
					<s:form cssClass="gg" method="post" action="insertArticle" theme="css_xhtml">
						<s:textfield type="text" required="true" name="article.designation" label="designation" labelposition="left"/>
						<s:textfield cssClass="textUpdate" required="true" errorPosition="bottom" type="text" name="article.prixUnitaire" label="prixUnitaire" labelposition="left"/>
						<s:textfield cssClass="textUpdate" required="true" errorPosition="bottom" type="text" name="article.quantite" label="quantite" labelposition="left"/>
						<s:select cssClass="textUpdate" name="categ" list="listCateg" listValue="designation" listKey="code"></s:select>
						<s:submit cssClass="textUpdate" name="Valider" value="Inserer"/>
					</s:form>
				</fieldset>
			</div>
		</div>
			
	</div>
</body>
</html>