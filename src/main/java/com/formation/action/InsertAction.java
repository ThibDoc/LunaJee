package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Action("/insert")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "insert.jsp"),
}) //@Result(name = "success", type="redirectAction", params="{"namespace","/","actionName","/index"}), pour rediriger vers une action
public class InsertAction extends ActionSupport {


	@Override
	public String execute()throws Exception {
		
		return SUCCESS;
	}

	
}
