<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexions</title>
</head>
<body>
	
	<div class="titre mt100"><img src="${pageContext.request.contextPath}/css/img/Moon-32.png"/></div>
	<div class="titre">Luna</div>
	<div class="blockCo">
		<h1>Login</h1>
		<div class="error"><s:text name="">${errorTxt}</s:text></div>
		<div class="input">
			<s:form method="post" action="j_spring_security_check" >
				<s:textfield cssClass="divUser" type="text" name='username' placeholder="Username"/>
				<s:textfield cssClass="divPass" type="password" name="password"  placeholder="Password"/>
				<s:submit cssClass="divSub" name="Valider" value="Valider" />
			</s:form>
		</div>
	</div>
</body>
</html>