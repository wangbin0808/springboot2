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

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import tk.mybatis.mapper.entity.SqlsCriteria;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.weekend.WeekendSqls;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectYTest {
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
	
	/**
	 * 通用方法的测试
	 */
	@Test
	public void test4(){
		Example example=new Example(Employee.class);
		example.isDistinct();
		example.createCriteria().orBetween("empId", 2, 11);
		// Preparing: SELECT emp_id,emp_name,emp_salary,emp_age,version
		//FROM tabple_emp WHERE ( emp_id between ? and ? ) 
		List<Employee> list = dao.selectByExample(example);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test5(){
		Example example=new Example(Employee.class);
		Criteria criteria = example.createCriteria();
		criteria.andLike("empName", "%san");
		//SELECT emp_id,emp_name,emp_salary,emp_age,version
		//FROM tabple_emp WHERE ( emp_name like ? )
		//Parameters: %san(String)
		List<Employee> list = dao.selectByExample(example);
		list.stream().forEach(System.out::println);
	}
	@Test
	public void test6(){
		//SELECT emp_id,emp_name,emp_salary,
		//emp_age,version FROM tabple_emp WHERE ( emp_name like ? )
		//Parameters: %san%(String)
		List<Employee> list =
				dao.selectByExample(new Example.Builder(Employee.class)
						.where(WeekendSqls.<Employee>custom()
								.andLike(Employee::getEmpName, "%san%"))
						.build());
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test7(){
		/**
		 * SELECT emp_id,emp_name,emp_salary,emp_age,
		 * version FROM tabple_emp WHERE ( emp_name like ? ) 
		 * Parameters: %an%(String)
		 * 
		 * new RowBounds(0, 3)这个走的是内存分页
		 */
		dao.selectByExampleAndRowBounds(Example
				.builder(Employee.class).andWhere(WeekendSqls.<Employee>custom()
						.andLike(Employee::getEmpName, "%an%")).build(),
				new RowBounds(0, 3)).forEach(System.out::println);;
	}
	/**
	 * 这个地方和Mybatis-Plus不一样，Mapper的在查询的时候是使用的是类的属性
	 * 而Mybatis-Plus使用的是表的字段
	 */
	@Test
	public void test8(){
		/**
		 * SELECT emp_name FROM tabple_emp WHERE
		 *  ( emp_age not between ? and ? ) order by emp_age Asc
		 *  Parameters: 30(Integer), 40(Integer)
		 */
		dao.selectByExample(Example.builder(Employee.class)
				.select("empName")
				.where(Sqls.custom()
						.orNotBetween("empAge", 30, 40))
				.orderByAsc("empAge").build()).forEach(System.out::println);
	}
}
