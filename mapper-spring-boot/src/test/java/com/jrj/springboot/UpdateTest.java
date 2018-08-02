package com.jrj.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeDao;
/**
 * updateByPrimaryKeySelective和updateByPrimaryKey的区别在于，前者有值则修改，没有值则不改
 * 而后者是则没有就改成默认值
 * @author Administrator
 * 
 * 
 * insertSelective 和 updateByPrimaryKeySelective 中，是否判断字符串类型 !=''。
	配置方式：notEmpty=true
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {
	@Autowired
	private EmployeeDao dao;
	
	@Test
	public void test1(){
		Employee employee = new Employee();
		employee.setEmpId(6);
		/**
		 * UPDATE tabple_emp SET emp_id = emp_id,emp_name = ?,
		 * emp_salary = ?,emp_age = ? WHERE emp_id = ?
		 * Parameters:null, null, null, 6(Integer)
		 */
		int key = dao.updateByPrimaryKey(employee);
		System.out.println(key+"----updateByPrimaryKey");
	}
	@Test
	public void test(){
		Employee employee = new Employee();
		employee.setEmpId(7);
		//UPDATE tabple_emp SET emp_id = emp_id WHERE emp_id = ?
		int i = dao.updateByPrimaryKeySelective(employee);
		System.out.println(i);
		Employee employee1 = new Employee();
		employee1.setEmpId(10);
		employee1.setEmpAge(2000);
		employee1.setEmpName("wangbin");
		employee1.setEmpSalary(20000.0);
		dao.updateSuccess(employee1);
	}
	
	@Test
	public void test2(){
		
	}
	

}
