package com.rg.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rg.model.Employee;
import com.rg.service.IEmpolyeeService;

@Component
public class EmployeeComp {
	@Autowired
	private IEmpolyeeService service;
	
	public void saveobj() {
		Employee e = new Employee();
		e.setEmpId(1);
		e.setEmpName("Ritik");
		e.setEmpSal(1000);
		service.saveEmpObject(e);
		Employee e1 = new Employee();
		e1.setEmpId(2);
		e1.setEmpName("Bhavey");
		e1.setEmpSal(2000);
		service.saveEmpObject(e1);
		Employee e2 = new Employee();
		e2.setEmpId(3);
		e2.setEmpName("Anuj");
		e2.setEmpSal(3000);
		service.saveEmpObject(e2);
		System.out.println("Object saved");
	}
	
	public void updateobj() {
		Employee e = new Employee();
		e.setEmpId(3);
		e.setEmpName("Anuj");
		e.setEmpSal(0);
		service.updateObject(e);
		System.out.println(e.getEmpSal());
		System.out.println("Object updated");
	}
}
