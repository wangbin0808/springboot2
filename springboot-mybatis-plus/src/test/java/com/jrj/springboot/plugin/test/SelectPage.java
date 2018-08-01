package com.jrj.springboot.plugin.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectPage {
	
	@Autowired
	private EmployeeMapper emp;
	
	@Test
	public void test1(){
		
		Page<Employee> page=new Page<>(1,10);
		List<Employee> list = emp.selectPage(page, null);
		list.stream().forEach(System.out::println);
		System.out.println(page);
		System.out.println("-----");
		System.out.println(page.getCurrent()+"当前页");
		System.out.println(page.getSize()+"yeshudaxiao");
		System.out.println(page.getTotal()+"zongyeshu");
		System.out.println(page.getPages());
		System.out.println(page.hasPrevious()+"shifoyoushangyiye");
		System.out.println(page.hasNext()+"shifoyouxiayiye");
	}
	
	@Test
	public void deleteAll(){
		emp.delete(null);
	}

}
