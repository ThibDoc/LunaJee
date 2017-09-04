package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.daos.ClientDAO;
import com.formation.entity.Adresse;
import com.formation.entity.Client;
import com.formation.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/client")
@ResultPath("/WEB-INF/pages")
@Results({ @Result(name = "success", location = "client.jsp"), @Result(name = "create", location = "client.jsp"),
		@Result(name = "input", location = "client.jsp") })
public class ClientAction extends ActionSupport implements ModelDriven<Client> {

	private static final long serialVersionUID = 1L;

	List<Client> listClients;
	Adresse adresse = new Adresse();
	Client client = new Client();
	

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
		listClients = clientService.getAllClients();
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
		clientService.CreateClient(getModel());
		return "create";
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

}