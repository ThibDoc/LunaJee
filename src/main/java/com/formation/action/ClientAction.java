package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.daos.ClientDAO;
import com.formation.entity.Client;
import com.opensymphony.xwork2.ActionSupport;

@Action("/client")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "client.jsp"),
})
public class ClientAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	List<Client> listClients;

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public String execute()throws Exception {
		
		listClients = clientDAO.getAllClients();
		return SUCCESS;
	}

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}
	
	
}