package com.jrj.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.em.EmplDao;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCache {
	@Autowired
	private EmplDao dao;
	@Test
	public void test1(){
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
