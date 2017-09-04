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
	
	<table>
		<tr>
			<td>Code</td>
			<td>Designation</td>
			<td>Prix Unitaire</td>
			<td>Quantite</td>
			<td>Categorie</td>
			<td>Supprimer / Modifier</td>
		</tr>
		<c:forEach  items="${listArticles}" var="article">
   			<tr>
   				<td> ${article.code}</td>
				<td> ${article.designation}</td>
				<td> ${article.prixUnitaire}</td>
				<td> ${article.quantite}</td>
				<td> ${article.categorie.designation}</td>
				<td> 
					<s:a action="deleteArticle">
					Supprimer<s:param name="codeArt">${article.code}</s:param>
					</s:a>
					<s:text name=" / "/>
					<s:a action="updateArticlePage">
					Modifier<s:param name="codeArt">${article.code}</s:param>
					</s:a>
					
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<s:form method="post" action="insertArticle" theme="css_xhtml">
		<s:textfield type="text" name="article.designation" label="designation" labelposition="left"/>
		<s:textfield type="text" name="article.prixUnitaire" label="prixUnitaire" labelposition="left"/>
		<s:textfield type="text" name="article.quantite" label="quantite" labelposition="left"/>
		<s:select name="categ" list="listCateg" listValue="designation" listKey="code"></s:select>
		<s:submit name="Valider" value="Inserer"/>
	</s:form>
	
</body>
</html>