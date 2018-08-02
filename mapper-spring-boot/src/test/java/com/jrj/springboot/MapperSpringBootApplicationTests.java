package com.jrj.springboot;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperSpringBootApplicationTests {
	
	@Autowired
	private EmployeeDao dao;

	@Test
	public void contextLoads() {
		//SELECT emp_id,emp_name,emp_salary,emp_age FROM tabple_emp 
		List<Employee> list = dao.selectAll();
		list.stream().forEach(System.out::println);
		
	}
	
	@Test
	public void test1(){
		Employee record=new Employee();
		record.setEmpName("bob");
		//SELECT emp_id,emp_name,emp_salary,emp_age FROM tabple_emp WHERE emp_name = ? 
		List<Employee> list = dao.select(record);
		list.stream().forEach(System.out::println);
	}
	@Test
	public void test2(){
		//INSERT INTO tabple_emp ( emp_id,emp_name,emp_salary,emp_age ) VALUES( ?,?,?,? )
		Employee record=new Employee(6,"bob",1000.0,10);
		dao.insert(record);
	}

	/**
	 * 在使用selectOne的时候，当查询出来的数据是两个或以上的时候会报错的
	 *  Expected one result (or null) to be returned by selectOne(), but found: 2
	 */
	@Test
	public void selectOne(){
		Employee record=new Employee();
		record.setEmpName("bob");
		Employee list = dao.selectOne(record);
		System.out.println(list);
		
	}
	
	@Test
	public void select1(){
		//SELECT emp_id,emp_name,emp_salary,emp_age FROM tabple_emp WHERE emp_id = ? 
		Employee key = dao.selectByPrimaryKey(6);
		System.out.println(key+"--selectByPrimaryKey");
		//SELECT COUNT(emp_id) FROM tabple_emp 
		int count = dao.selectCount(new Employee());
		System.out.println(count+"----selectCount");
		//SELECT emp_id,emp_name,emp_salary,emp_age FROM tabple_emp 
		List<Employee> list = dao.selectByRowBounds(null, new RowBounds(0, 2));
		list.forEach(System.out::println);
		System.out.println("---selectByRowBounds");
	}
	
	
}
