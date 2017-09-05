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
			<div class="updategauche">
				<div class="search">
					<s:form cssClass="searchc" method="post" action="client"
						theme="css_xhtml">
						<s:textfield cssClass="searchField" type="text" name="search"
							placeholder="Rechercher" />
						<s:submit cssClass="searchButon" name="Chercher" value=" " />
					</s:form>
				</div>

				<div class="search">
					<s:a cssClass="textAdd" action="client">
						Ajouter un Client
					</s:a>
				</div>

			</div>
			<div class="updatecenter">
				<fieldset>
					<legend>Création</legend>
					<s:form cssClass="formulaire" action="createClient" method="post"
						theme="css_xhtml">
					<div class="ligne">
						<s:textfield label="Nom" required="true" name="client.nom"
							labelposition="left" />
						<s:textfield label="Prenom" name="client.prenom" required="true"
							labelposition="left" />
					</div>		
						<s:textfield label="Rue" name="client.adresse.rue" required="true"
							labelposition="left" />
					<div class="ligne">		
						<s:textfield label="Code postal" name="client.adresse.codePostal"
							required="true" labelposition="left" errorPosition="bottom" />
						<s:textfield label="Ville" name="client.adresse.ville"
							required="true" labelposition="left" />
					</div>	
						<s:radio label="Carte de fidélité" labelposition="left"
							id="radiobutton" name="carte_fidelite"
							list="#{'true' : 'oui', 'false' : 'non'}" value="false" />
						<s:submit label="Enregistrer" />
					</s:form>
				</fieldset>
			</div>
		</div>

	</div>
</body>
</html>