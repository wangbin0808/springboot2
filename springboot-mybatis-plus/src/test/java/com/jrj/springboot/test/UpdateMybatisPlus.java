package com.jrj.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeMapper;

/**
 * 
 * @author bin.wang
 * 修改的类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateMybatisPlus {
	
	@Autowired
	private EmployeeMapper emp;
	/**
	 *  Integer updateById(@Param("et") T entity);
	 *  这个方法是按id来查找的
	 */
	@Test
	public void test1(){
		/**
		 * UPDATE tbl_employee SET last_name=?, 
		 * email=?, gender=?, age=? WHERE id=?
		 * wangbin(String), wangbin@qq.com(String), 
		 * 1(Integer), 20(Integer), 1341(Integer)
		 */
		Integer id = emp.updateById(new Employee(1341, "wangbin", "wangbin@qq.com",
				1, 20));
		System.out.println(id);
	}
	/**
	 * Integer update(@Param("et") T entity, @Param("ew") Wrapper<T> wrapper);
	 * 这个方法是吧Wrapper当作是where后面的条件，来查找要修改的对象
	 */
	@Test
	public void test2(){

		/**
		 * Preparing: UPDATE tbl_employee SET last_name=?,
		 *  email=?, gender=?, age=? WHERE (age = ?) 
           Parameters: wangbin(String), wangbin@qq.com(String), 
           1(Integer), 20(Integer), 900(Integer)
		 */
		Employee employee = new Employee(1341, "wangbin", "wangbin@qq.com",
				1, 20);
		Integer integer = emp.update(employee, new EntityWrapper<Employee>()
				.eq("age", 900));
		System.out.println(integer);
	}

	/**
	 * Integer updateForSet(@Param("setStr") String setStr, @Param("ew") Wrapper<T> wrapper);
	 */
	@Test
	public void test3(){
		Integer set = emp.updateForSet("last", new EntityWrapper<Employee>()
				.eq("age", 900));
		System.out.println(set);
	}

}
