package com.rg.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rg.dao.IEmployeeDao;
import com.rg.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{
	@Autowired
	private HibernateTemplate ht;
	@Override
	public void saveEmpObject(Employee emp) {
		ht.save(emp);
	}
	@Override
	public void updateObject(Employee emp) {
		ht.update(emp);
	}

}
