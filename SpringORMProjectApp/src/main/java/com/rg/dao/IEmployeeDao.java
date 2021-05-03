package com.rg.dao;

import com.rg.model.Employee;

public interface IEmployeeDao {
	public void saveEmpObject(Employee emp);
	public void updateObject(Employee emp);
}