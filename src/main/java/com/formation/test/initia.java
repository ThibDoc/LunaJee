package com.formation.test;

public class CustomerAction extends ActionSupport
implements ModelDriven{

//have to initialize it
Customer customer = new Customer();

public String execute() throws Exception {

	return SUCCESS;

}

public Object getModel() {

	return customer;

}
public static void main(String[] args) {
	ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("application-Context.xml");
	
}
}