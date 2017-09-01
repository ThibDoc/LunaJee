package com.formation.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.entity.EmployeeEntity;

@Repository("employeeDAO") // Va etre scanner par Spring, objet gerer par spring donc backend
@Transactional // Pour rendre la classe transactionelle
public class EmployeeDaiImpl implements EmployeeDAO{
	
	@Autowired // Pour injecter le sessionFactory du fichier xml ici, on doit ajouter le setters
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().save(employee);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(EmployeeEntity.class, employeeId);
		if(null != employee) this.sessionFactory.getCurrentSession().delete(employee);
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
