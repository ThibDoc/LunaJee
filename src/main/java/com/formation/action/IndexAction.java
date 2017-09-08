package com.formation.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import com.opensymphony.xwork2.ActionSupport;

@Action("/index")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "index.jsp"),
	@Result(name = "error", location = "index.jsp"),
})
public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String errorTxt;
	
	@Override
	public String execute()throws Exception {
		return SUCCESS;
	}

	@Action("gg")
	public String gg()throws Exception{
		errorTxt = "Mauvais login ou mdp !";
		return ERROR;
	}

	public String getErrorTxt() {
		return errorTxt;
	}

	public void setErrorTxt(String errorTxt) {
		this.errorTxt = errorTxt;
	}
	
	
}
