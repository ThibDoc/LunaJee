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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/client")
@ResultPath("/WEB-INF/pages")
@Results({ @Result(name = "success", location = "client.jsp"),
	@Result(name = "create", location = "client.jsp"),
	@Result(name = "input",  location = "client.jsp"),
	@Result(name = "delete", location = "client.jsp"),
	@Result(name = "update", location = "client.jsp"),
	@Result(name = "updatePage", location = "updateClient.jsp")})
public class ClientAction extends ActionSupport implements ModelDriven<Client> {

	private static final long serialVersionUID = 1L;

	List<Client> listClients;
	Adresse adresse = new Adresse();
	Client client = new Client();
	private int codeCli;
	private Client clientUpdate;
	

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
	

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	@Action("createClient")
	public String createClient() throws Exception {
		load();
		System.out.println(getModel().isCarteFidele());
		getModel().setDate(Calendar.getInstance().getTime());
		clientService.CreateClient(getModel());
		load();
		return "create";
	}
	
	@Action("deleteClient")
	public String deleteClient() throws Exception {
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
		load();
		clientService.updateClient(clientUpdate);
		load();
		return "update";
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
	

}