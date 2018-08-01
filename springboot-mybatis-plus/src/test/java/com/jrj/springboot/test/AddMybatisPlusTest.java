package com.jrj.springboot.test;

import static org.assertj.core.api.Assertions.contentOf;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeMapper;
/**
 * 
 * @author bin.wang
 * 这个类是插入数据
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddMybatisPlusTest {
	
	@Autowired
	private EmployeeMapper emp;
	
	@Test
	public void test1(){
		Employee entity=
				new Employee(null, "yangxin", "yangxin@qq.com", 0, 56);
		emp.insert(entity);
		System.out.println(entity.getId());
	}
	
	
	@Test
	public void test2(){
		String ad="abcdefghijklmnopquixtuvwxyz";

		int[] a=new int[5];
		String name="";

		for (int i = 0; i <1000; i++) {
			for (int n = 0; n < 5; n++) {
				int nextInt = new Random().nextInt(26);
				a[n]=nextInt;
			}
			for (int j = 0; j < a.length; j++) {
				name+=ad.charAt(a[j]);
			}
			System.out.println(name);
			Employee entity=new Employee();
			entity.setLastName(name);
			entity.setAge(i);
			entity.setEmail(name+"@qq.com");
			entity.setGender(i%2==0?1:0);
			name="";
			emp.insert(entity);
		}
	}
	
	@Test
	public void test3(){
		//这个是在插入数据的时候，不用判断为空的，没有值，就按默认值来插入数据
		
		Integer column = emp.insertAllColumn(new Employee(null, null, "allcom", 1, 90));
		System.out.println(column);
		
	}


}
