package com.jrj.springboot;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeDao;

import tk.mybatis.mapper.annotation.KeySql;
/**
 * 
 * @author bin.wang
 * 插入数据
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

	@Autowired
	private EmployeeDao dao;
	@Test
	public void test2(){
		//INSERT INTO tabple_emp ( emp_id,emp_name,emp_salary,emp_age ) VALUES( ?,?,?,? )
		Employee record=new Employee(6,"bob",1000.0,10);
		dao.insert(record);
	}
	/**
	 * insertSelective这个方法在插入数据的时候是不能得到主键的
	 */
	@Test
	public void test1(){
		Employee employee = new Employee();
		employee.setEmpName("wangwu");
		employee.setEmpSalary(100.0);
		//INSERT INTO tabple_emp ( emp_name,emp_salary ) VALUES( ?,? ) 
		dao.insertSelective(employee);
		System.out.println(employee.getEmpId());
	}
	/**
	 * insert也不能返回主键的值
	 * 但是在Employee这个类里面的主键id上添加	@KeySql(useGeneratedKeys=true)或者
	 * @GeneratedValue(strategy=GenerationType.IDENTITY)这个都可以获得主键
	 * 可以参考官方文档：https://gitee.com/free/Mapper/wikis/pages?
	 * title=2.3-generatedvalue&parent=2.orm
	 */
	@Test
	public void test3(){
		Employee employee = new Employee();
		employee.setEmpName("zhangsan");
		employee.setEmpSalary(1000.0);
		// INSERT INTO tabple_emp ( emp_id,emp_name,emp_salary,emp_age ) VALUES( ?,?,?,? ) 
		dao.insert(employee);
		System.out.println(employee.getEmpId());
	}
	
	
	@Test
	public void test4(){
		Employee employee = new Employee();
		employee.setEmpName("zhaoliu");
		employee.setEmpSalary(1000.0);
		employee.setEmpAge(20);
		dao.insertReturnId(employee);
		System.out.println(employee.getEmpId());
	}
}
