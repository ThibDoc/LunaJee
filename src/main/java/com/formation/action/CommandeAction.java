package com.formation.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.daos.CategorieDAO;
import com.formation.daos.CommandeDAO;
import com.formation.daos.ModeReglementsDAO;
import com.formation.entity.Article;
import com.formation.entity.Categorie;
import com.formation.entity.Client;
import com.formation.entity.Commande;
import com.formation.entity.Ligne;
import com.formation.entity.ModeReglements;
import com.formation.service.ArticleService;
import com.formation.service.ClientService;
import com.formation.service.CommandeService;
import com.formation.service.LigneService;
import com.formation.service.ModeReglementsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/commande")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "commande.jsp"),
	@Result(name = "delete", location = "commande.jsp"),
	@Result(name = "update", location = "commande.jsp"),
	@Result(name = "updatePage", location = "updateCommande.jsp"),
	@Result(name = "search", location = "commande.jsp"),
	@Result(name = "createPage", location = "createCommande.jsp"),
	@Result(name = "createCommandeArticle", location = "createCommande.jsp"),
	@Result(name = "deleteArticleCommande", location = "createCommande.jsp"),
	@Result(name = "createUneCommande", location = "commande.jsp"),
})
public class CommandeAction extends ActionSupport  implements ModelDriven<Commande>{

	private static final long serialVersionUID = 1L;
	private int codeCom;
	private Commande commandeUpdate;
	private Client client;
	private int idCli;
	private int codeReg;
	private int codeArt;
	private int quantite;
	Commande commande = new Commande();
	ModeReglements modeReglement;
	
	@Autowired
	private CommandeService commandeDAO;
	
	@Autowired
	private ArticleService articleDAO;

	@Autowired
	private ClientService clientDAO;
	
	@Autowired
	private ModeReglementsService modesDAO;
	
	@Autowired
	private LigneService ligneDAO;
	
	List<Commande> listCommandes;
	List<Article> listArticles;
	List<Client> listClients;
	List<ModeReglements> listModes;
	
	static final List<Article> listArticlesCommandes= new ArrayList<Article>();
	static final List<Ligne> listLigneCommandes= new ArrayList<Ligne>();
	Article unArticle;
	
	@Override
	public String execute()throws Exception {
		load();
		listArticlesCommandes.clear();
		System.out.println(listCommandes.get(0).getModeReglement().getType());
		return SUCCESS;
	}
	
	@Action("deleteCommande")
	public String deleteCommande()throws Exception {
		commandeDAO.DeleteCommande(codeCom);
		load();
		return "delete";
	}
	
	@Action("updateCommandePage")
	public String updateCommandePage()throws Exception {
		load();
		commandeUpdate = commandeDAO.getCommande(codeCom);
		commandeUpdate.setCode(codeCom);
		client = commandeUpdate.getClient();
		modeReglement = commandeUpdate.getModeReglement();
		System.out.println(modeReglement.getCode());
		return "updatePage";
	}
	
	@Action("updateCommande")
	public String updateCommande()throws Exception {
		commandeUpdate.setCode(codeCom);
		commandeDAO.updateCommande(commandeUpdate);
		load();
		return "update";
	}
	
	@Action("searchCommande")
	public String searchCommande()throws Exception {
		load();
		listCommandes.clear();
		listCommandes = commandeDAO.getCommandeByCli(idCli);
		return "search";
	}
	
	@Action("createCommandePage")
	public String createCommandePage()throws Exception {
		load();
		return "createPage";
	}
	
	@Action("createCommandeArticle")
	public String createCommandeArticle()throws Exception {
		unArticle = articleDAO.getArticle(codeArt);
		unArticle.setQuantite(quantite);
		System.out.println(unArticle.getDesignation());
		if(listArticlesCommandes.contains(unArticle)){

			
		}else{
			
			listArticlesCommandes.add(unArticle);
		}
		
		load();
		return "createCommandeArticle";
	}
	
	@Action("deleteArticleCommande")
	public String deleteArticleCommande()throws Exception {
		load();
		listArticlesCommandes.remove(codeArt);
		return "deleteArticleCommande";
	}
	
	@Action("createUneCommande")
	public String createUneCommande()throws Exception {
		load();
		commande.setClient(clientDAO.getClient(idCli));
		commande.setModeReglement(modesDAO.getModeReglements(codeReg));
		commande.setDate(new Date());
		commandeDAO.CreateCommande(commande);
		for(Article art: listArticlesCommandes ){
			Ligne ligne = new Ligne();
			ligne.setArticle(art);
			ligne.setQuantite(art.getQuantite());
			ligne.setCommande(commande);
			listLigneCommandes.add(ligne);
			ligneDAO.CreateLigne(ligne);
		}
		commande.setLignes(listLigneCommandes);
		commandeDAO.updateCommande(commande);
		load();
		return "createUneCommande";
	}
	
	public List<Commande> getListCommandes() {
		return listCommandes;
	}

	public void setListCommandes(List<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}
	
	public void load() {
		listArticles = articleDAO.getAllArticles();
		listCommandes = commandeDAO.getAllCommandes();
		listClients = clientDAO.getAllClients();
		listModes = modesDAO.getAllModeReglements();
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public ModeReglements getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(ModeReglements modeReglement) {
		this.modeReglement = modeReglement;
	}

	public int getCodeCom() {
		return codeCom;
	}

	public void setCodeCom(int codeCom) {
		this.codeCom = codeCom;
	}

	public Commande getCommandeUpdate() {
		return commandeUpdate;
	}

	public void setCommandeUpdate(Commande commandeUpdate) {
		this.commandeUpdate = commandeUpdate;
	}

	@Override
	public Commande getModel() {
		// TODO Auto-generated method stub
		return commande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getIdCli() {
		return idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	public List<Article> getListArticlesCommandes() {
		return listArticlesCommandes;
	}

	

	public Article getUnArticle() {
		return unArticle;
	}

	public void setUnArticle(Article unArticle) {
		this.unArticle = unArticle;
	}

	public int getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public static List<Article> getListarticlescommandes() {
		return listArticlesCommandes;
	}

	public static List<Ligne> getListlignecommandes() {
		return listLigneCommandes;
	}

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	public List<ModeReglements> getListModes() {
		return listModes;
	}

	public void setListModes(List<ModeReglements> listModes) {
		this.listModes = listModes;
	}

	public int getCodeReg() {
		return codeReg;
	}

	public void setCodeReg(int codeReg) {
		this.codeReg = codeReg;
	}
	
	
	
}
