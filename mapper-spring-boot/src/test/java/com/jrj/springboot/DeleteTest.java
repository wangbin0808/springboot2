package com.jrj.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {

	@Autowired
	private EmployeeDao dao;
	
	@Test
	public void test1(){
		//Preparing: DELETE FROM tabple_emp WHERE emp_id = ? AND version = ? 
		//Parameters: 6(Integer), 6(Integer)
		int key = dao.deleteByPrimaryKey(6);
		System.out.println(key);
	}
	
	
	@Test
	public void test2(){

		Employee employee = new Employee();
		employee.setEmpId(6);
		employee.setVersion(0);
		int key = dao.deleteWithVersion(employee);
		System.out.println(key);
	}
}
