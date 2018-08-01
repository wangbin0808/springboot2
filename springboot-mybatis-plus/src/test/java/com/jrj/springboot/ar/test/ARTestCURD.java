package com.jrj.springboot.ar.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ARTestCURD {
	

	
	@Test
	public void test1(){
		Dept dept=new Dept();
		dept.selectAll().forEach(System.out::println);
	}

}
