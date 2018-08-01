package com.jrj.springboot.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeMapper;
/**
 * 
 * @author bin.wang
 * 这个类是删除
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteMybatisPlus {
	
	@Autowired
	private EmployeeMapper emp;
	
	@Test
	public void test1(){
		Integer integer = emp.delete(new EntityWrapper<Employee>()
				.like("last_name", "wang"));
		System.out.println(integer);
	}
	
	@Test
	public void test2(){

		Map<String, Object> columnMap=new HashMap<>();
		columnMap.put("last_name", "klwuf");
		Integer map = emp.deleteByMap(columnMap);
		System.out.println(map);
	}
	
	@Test
	public void test3(){

		Wrapper<Employee> wrapper=new EntityWrapper<>();
		wrapper.like(true, "last_name", "ab");
		Integer integer = emp.delete(wrapper);
		System.out.println(integer);
	}
	
	@Test
	public void test4(){

		Wrapper<Employee> wrapper=new EntityWrapper<>();
		wrapper.like(true, "last_name", "ab");
		Integer integer = emp.delete(wrapper);
		System.out.println(integer);
	}

}
