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
	href="${pageContext.request.contextPath}/css/article.css"
	type="text/css">
<title>Article</title>
</head>
<body>


	<div class="tous">
		<div class="dd">
			<s:form cssClass="boutton" method="post" action="menu"
				theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Menu" />
			</s:form>
			<s:form method="post" action="client" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Client" />
			</s:form>
			<s:form method="post" action="article" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Article" />
			</s:form>
			<s:form method="post" action="commande" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Commande" />
			</s:form>
		</div>
		<div class="article">
			<div class="panelgauche">
				<div class="search">
					<s:form cssClass="searchc" method="post" action="searchArticle"
						theme="css_xhtml">
						<s:textfield cssClass="searchField" type="text" name="name"
							placeholder="Rechercher" />
						<s:submit cssClass="searchButon" name="Chercher" value=" " />
					</s:form>
				</div>

				<div class="search">
					<s:a cssClass="textAdd" action="createArticlePage">
						Ajouter un article
					</s:a>
				</div>


			</div>
			<div class="fff">
				<table>
					<tr class="entete">
						<td class="lefttab">Code</td>
						<td>Designation</td>
						<td>Prix Unitaire</td>
						<td>Quantite</td>
						<td>Categorie</td>
						<td>Supprimer</td>
						<td class="righttab">Modifier</td>
					</tr>
					<s:if test="%{listArticles.size()==0}">
						<tr>
							<td colspan="7">Aucun article</td>
						</tr>
					</s:if>
					<s:else>
						<c:forEach items="${listArticles}" var="article">
							<tr>
								<td>${article.code}</td>
								<td>${article.designation}</td>
								<td>${article.prixUnitaire}</td>
								<td>${article.quantite}</td>
								<td>${article.categorie.designation}</td>
								<td><s:a action="deleteArticle">
										<img alt=""
											src="${pageContext.request.contextPath}/css/img/Garbage-Open-48.png"
											width="30px">
										<s:param name="codeArt">${article.code}</s:param>
									</s:a></td>
								<td><s:a action="updateArticlePage">
										<img alt=""
											src="${pageContext.request.contextPath}/css/img/Data-Edit-48.png"
											width="30px">
										<s:param name="codeArt">${article.code}</s:param>
									</s:a></td>
							</tr>
						</c:forEach>
					</s:else>
				</table>
			</div>
		</div>
	</div>
</body>
</html>