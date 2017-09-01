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
	href="${pageContext.request.contextPath}/css/client.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr>
			<td>Code</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Date</td>
		</tr>
		<c:forEach  items="${listClients}" var="client">
   			<tr>
   				<td> ${client.code}</td>
				<td> ${client.nom}</td>
				<td> ${client.prenom}</td>
				<td>
					<fmt:formatDate value="${client.date}" pattern="yyyy-MM-dd" />
					<c:out value = "${parsedDate}" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>