package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Action("/commande")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "commande.jsp"),
})
public class CommandeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute()throws Exception {
		
		return SUCCESS;
	}
}
