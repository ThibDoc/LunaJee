package com.formation.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.daos.ArticleDAO;
import com.formation.util.Statistique;
import com.opensymphony.xwork2.ActionSupport;

@Action("/stats")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "stats.jsp"),
})
public class StatsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ArticleDAO articleDAOs;
	
	@Override
	public String execute()throws Exception {
		File file = new File("C:\\Users\\Dimi\\git\\LunaJee\\src\\main\\webapp\\css\\img\\stats.png");
		file.delete();
		Statistique f = new Statistique();
		f.testss(articleDAOs);
		return SUCCESS;
	}
}
