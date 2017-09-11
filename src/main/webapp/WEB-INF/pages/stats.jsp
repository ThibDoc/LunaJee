<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/stats.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
			<s:form method="post" action="stats" theme="css_xhtml">
				<s:submit cssClass="text" name="Valider" value="Statistique" />
			</s:form>
		</div>
		<div class="article">
				<div class="stat"><img src="${pageContext.request.contextPath}/css/img/stats.png"/></div>
		</div>
	</div>

</body>
</html>