package com.formation.action;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.daos.ClientDAO;
import com.formation.entity.Adresse;
import com.formation.entity.Article;
import com.formation.entity.Client;
import com.formation.service.ClientService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.PreResultListener;

@Action("/client")
@ResultPath("/WEB-INF/pages")
@Results({ @Result(name = "success", location = "client.jsp"),
	@Result(name = "create", location = "client.jsp"),
	@Result(name = "input", location = "createClient.jsp"),
	@Result(name = "delete", location = "client.jsp"),
	@Result(name = "update", location = "client.jsp"),
	@Result(name = "createPage", location = "createClient.jsp"),
	@Result(name = "updatePage", location = "updateClient.jsp")})
public class ClientAction extends ActionSupport implements ModelDriven<Client>,Preparable {

	private static final long serialVersionUID = 1L;

	List<Client> listClients;
	Adresse adresse = new Adresse();
	Client client = new Client();
	private int codeCli;
	private Client clientUpdate;
	private boolean carte_fidelite;
	

	public boolean isCarte_fidelite() {
		return carte_fidelite;
	}

	public void setCarte_fidelite(boolean carte_fidelite) {
		this.carte_fidelite = carte_fidelite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	@Autowired
	private ClientService clientService;

	@Override
	public String execute() throws Exception {
		load();
		return SUCCESS;
	}

	public int getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(int codeCli) {
		this.codeCli = codeCli;
	}

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	@Action("createClient")
	public String createClient() throws Exception {
		load();
		getModel().setCarteFidele(carte_fidelite);
		getModel().setDate(Calendar.getInstance().getTime());
		clientService.CreateClient(getModel());
		load();
		return "create";
	}
	
	public Client getClientUpdate() {
		return clientUpdate;
	}

	public void setClientUpdate(Client clientUpdate) {
		this.clientUpdate = clientUpdate;
	}

	@Action("deleteClient")
	public String deleteClient() throws Exception {
		System.out.println(codeCli);
		clientService.DeleteClient(codeCli);
		
		load();
		return "delete";
	}
	
	@Action("updateClientPage")
	public String updateClientPage()throws Exception {
		load();
		clientUpdate = clientService.getClient(codeCli);
		clientUpdate.setCode(codeCli);
		
		return "updatePage";
	}
	
	@Action("updateClient")
	public String updateClient()throws Exception {
		clientUpdate.setCode(codeCli);
		clientService.updateClient(clientUpdate);
		load();
		return "update";
	}
	
	@Action("createClientPage")
	public String createPage()throws Exception {
		load();
		return "createPage";
	}
	
//	@Action("searchArticle")
//	public String searchArticle()throws Exception {
//		load();
//		listClients.clear();
//		listClients.add(clientService.getArticleByName());
//		return "search";
//	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public Client getModel() {
		// TODO Auto-generated method stub
		return client;
	}
	
	public void load() {
		listClients = clientService.getAllClients();
	}

	@Override
	public void prepare() throws Exception {
		load();
	}

}