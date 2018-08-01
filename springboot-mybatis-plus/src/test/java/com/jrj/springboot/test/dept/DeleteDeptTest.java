package com.jrj.springboot.test.dept;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Dept;
import com.jrj.springboot.dao.DeptMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteDeptTest {

	@Autowired
	private DeptMapper dept;
	/**
	 * 自定义注入全表删除方法 deteleAll
	 */
	@Test
	public void test1(){
		dept.deleteAll();
	}
	/**
	 * 公共字段自动填充
	 */
	@Test
	public void test2(){
		Dept de=new Dept();
		de.setAge(890);
		de.setEmail("6666");
		dept.insert(de);
	}
	/**
	 * 逻辑删除效果
	 */
	
	@Test
	public void test3(){
		for (int i = 0; i < 10; i++) {
			Dept de=new Dept(null,"wang","wang@qq.com",1,10);

			dept.insert(de);
		}

	}
	
	@Test
	public void test4(){
	//	Dept de=new Dept();

		dept.deleteById(23);
	}
}

