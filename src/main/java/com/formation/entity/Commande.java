package com.formation.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.formation.util.ConvertisseurLocalDateTime;
import com.formation.util.GestionDates;


@Entity
@NamedQuery(name = "chercherCommande", query = 
		"SELECT com FROM Commande com, "
		+ "Client cli, "
		+ "ModeReglements mode "
		+ "WHERE com.modeReglement.code = mode.code "
		+ "AND com.client.code = cli.code "
		+ "AND ("
			+ "com.code LIKE :recherche "
			+ "OR cli.nom LIKE :recherche "
			+ "OR cli.prenom LIKE :recherche "
			+ "OR mode.type LIKE :recherche"
		+ ")"
)
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int code;

	@ManyToOne
	private Client client;

	@ManyToOne
	@JoinColumn(name = "mode_reglement_code")
	private ModeReglements modeReglement;

	@Convert(converter=ConvertisseurLocalDateTime.class)
	private LocalDateTime date;

	@OneToMany(	cascade = { CascadeType.ALL },
				mappedBy = "commande")
	private List<Ligne> lignes = new ArrayList<>();

	/*
	 * Constructeur 1
	 */
	public Commande(Client client, ModeReglements modeReglement, LocalDateTime date, List<Ligne> lignes) {
		super();
		this.client = client;
		this.modeReglement = modeReglement;
		this.date = date;
		this.lignes = lignes;
	}

	/*
	 * Constructeur 2
	 */
	public Commande() {
		super();
	}

	

	/*
	 * Accesseurs
	 */
	public int getCode() {
		return code;
	}

	public Client getClient() {
		return client;
	}

	public double getTotalTTC() {
//		double total = 0;
//		for (Ligne ligne : lignes) {
//			total += ligne.getTotal();
//		}
//		return total;
		return lignes
				.stream()
				.mapToDouble(Ligne::getTotal)
				.sum();
	}

	public ModeReglements getReglement() {
		return modeReglement;
	}

	public Instant getInstant() {
		return GestionDates.instant(date);
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setReglement(ModeReglements leReglement) {
		this.modeReglement = leReglement;
	}

	void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public LocalDateTime maintenant() {
		setDate(GestionDates.maintenant());
		return date;
	}

	public List<Ligne> getLignes() {
		return lignes;
	}

	public void ajouter(Ligne uneLigne) {
		uneLigne.setCommande(this);
		lignes.add(uneLigne);
	}

	// ------------------------------------
	// Méthodes utilisées par Jasper
	// ------------------------------------
	@Deprecated
	public Date getDate() {
		return Date.from(getInstant());
	}
	// ------------------------------------
}
