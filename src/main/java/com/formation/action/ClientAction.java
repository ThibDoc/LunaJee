package com.formation.action;

import java.util.Calendar;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import com.formation.entity.Adresse;
import com.formation.entity.Client;
import com.formation.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Action("/client")
@ResultPath("/WEB-INF/pages")
@Results({ @Result(name = "success", location = "client.jsp"),
	@Result(name = "create", location = "client.jsp"),
	@Result(name = "input", location = "createClient.jsp"),
	@Result(name = "delete", location = "client.jsp"),
	@Result(name = "update", location = "client.jsp"),
	@Result(name = "createPage", location = "createClient.jsp"),
	@Result(name = "updatePage", location = "updateClient.jsp"),
	@Result(name = "search", location = "client.jsp")})
public class ClientAction extends ActionSupport implements ModelDriven<Client>,Preparable {

	private static final long serialVersionUID = 1L;

	private List<Client> listClients; /// liste des clients
	
	Adresse adresse = new Adresse(); 
	Client client = new Client();
	
	private int codeCli;
	private Client clientUpdate;
	private boolean carte_fidelite;
	private String name;

	@Autowired
	private ClientService clientService;

	@Override
	public String execute() throws Exception {
		load();
		return SUCCESS;
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
		clientUpdate.setCarteFidele(carte_fidelite);
		clientService.updateClient(clientUpdate);
		load();
		return "update";
	}
	
	@Action("createClientPage")
	public String createPage()throws Exception {
		load();
		return "createPage";
	}
	
	@Action("searchClient")
	public String searchArticle() throws Exception {
		load();
		listClients.clear();
		listClients = clientService.getClientByName(name);
		return "search";
	}

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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
	
	public Client getClientUpdate() {
		return clientUpdate;
	}

	public void setClientUpdate(Client clientUpdate) {
		this.clientUpdate = clientUpdate;
	}

}