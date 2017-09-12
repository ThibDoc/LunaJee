<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
		<div class="titre">
			<h1>Modifier un client</h1>
		</div>
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
			<div class="updategauche">
				

				<div class="search">
					<s:a cssClass="textAdd" action="client">
						Retour
					</s:a>
				</div>


			</div>
			<div class="updatecenter">
				<fieldset>
					<legend>Modification</legend>
					<s:form method="post" action="updateClient" theme="css_xhtml">
						<div class="ligne">
							<s:textfield label="Nom" name="clientUpdate.nom"
								labelposition="left" />
							<s:textfield label="Prenom" name="clientUpdate.prenom"
								required="true" labelposition="left" />
						</div>
						<s:textfield label="Rue" name="clientUpdate.adresse.rue"
							required="true" labelposition="left" />
						<div class="ligne">
							<s:textfield label="Code postal"
								name="clientUpdate.adresse.codePostal" required="true"
								labelposition="left" />
							<s:textfield label="Ville" name="clientUpdate.adresse.ville"
								required="true" labelposition="left" />
						</div>
						<s:radio label="Carte de fidélité" labelposition="left"
							id="radiobutton" name="carte_fidelite"
							list="#{'true' : 'oui', 'false' : 'non'}" value="clientUpdate.isCarteFidele" />
						<s:textfield type="hidden" name="clientUpdate.date">
							<s:param name="clientUpdate.date">${clientUpdate.date}</s:param>
						</s:textfield>
						<s:textfield type="hidden" name="codeCli">
							<s:param name="codeCli">${codeCli}</s:param>
						</s:textfield>
						<s:submit value="Enregistrer" label="Enregistrer" />
					</s:form>
				</fieldset>
			</div>
		</div>
	</div>


</body>
</html>