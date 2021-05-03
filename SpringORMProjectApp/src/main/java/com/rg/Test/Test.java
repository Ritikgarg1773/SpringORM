package com.rg.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rg.com.EmployeeComp;
import com.rg.config.AppConfig;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeComp emp = ac.getBean("employeeComp",EmployeeComp.class);
//		emp.saveobj();
		emp.updateobj();
		
 	}

}
