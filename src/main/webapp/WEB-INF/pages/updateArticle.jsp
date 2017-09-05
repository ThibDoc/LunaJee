<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/article.css" type="text/css">
<title>Article</title>
</head>
<body>
	
	<s:form method="post" action="updateArticle" theme="css_xhtml">
		<s:textfield type="text" name="articleUpdate.designation" label="designation" labelposition="left"/>
		<s:textfield type="text" name="articleUpdate.prixUnitaire" label="prixUnitaire" labelposition="left"/>
		<s:textfield type="text" name="articleUpdate.quantite" label="quantite" labelposition="left"/>
		<s:textfield type="hidden" name="codeArt"><s:param name="codeArt">${codeArt}</s:param></s:textfield>
		<s:select name="categ" list="listCateg" listValue="designation" listKey="code"></s:select>
		<s:submit name="Valider" value="Inserer"/>
	</s:form>
	
</body>
</html>