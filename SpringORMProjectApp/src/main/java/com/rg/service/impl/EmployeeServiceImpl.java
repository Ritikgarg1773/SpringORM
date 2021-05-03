package com.rg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rg.dao.IEmployeeDao;
import com.rg.model.Employee;
import com.rg.service.IEmpolyeeService;

@Service
public class EmployeeServiceImpl implements IEmpolyeeService{
	@Autowired
	private IEmployeeDao dao;
	
	@Override
	@Transactional
	public void saveEmpObject(Employee emp) {
		// TODO Auto-generated method stub
		dao.saveEmpObject(emp);
	}
	@Override
	@Transactional
	public void updateObject(Employee emp) {
		dao.updateObject(emp);
	}
}
