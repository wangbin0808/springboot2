package com.jrj.springboot.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.entity.Columns;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeMapper;
/**
 * 
 * @author bin.wang
 * 这个类里面主要是查询的一些操作
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatisplus {
	
	@Autowired
	ApplicationContext ioc;
	
	@Autowired
	private EmployeeMapper emp;
	
	@Test
	public void test1(){
		List<Employee> list = emp.selectList(new EntityWrapper<Employee>());
		list.stream().forEach(System.out::println);
		System.out.println(emp.getClass());
	}
	
	
	@Test
	public void test2(){
		EntityWrapper<Employee> wrapper=new EntityWrapper<>();
//		wrapper.gt("age", 18);
//		wrapper.lt("age", 80);
		wrapper.eq("gender", 1);
		wrapper.orderBy("age")
	//	.orderDesc(Arrays.asList(new String[]{"age"}));
		.last("desc limit 1,3");
		List<Employee> list = emp.selectList(wrapper);
		list.stream().forEach(System.out::println);
		
	}
	
	@Test
	public void test3(){

		List<Employee> list = emp.selectList(new EntityWrapper<Employee>());
		list.stream().forEach(System.out::println);
		
		System.out.println("-----selectList");
		Employee employee = emp.selectById(3);
		System.out.println("selectById----："+employee);
		Map<String ,Object> map=new HashMap<>();
		map.put("last_name", "wangbin");
		List<Employee> selectByMap = emp.selectByMap(map);
		selectByMap.stream().forEach(System.out::println);
		System.out.println("selectByMap--在这个里面可以添加key是数据库的字段，找wangbin来");
		
		List<Employee> page = emp.selectPage(new Page<>(0, 7), null);
		page.stream().forEach(System.out::println);
		System.out.println("selectPage-----:");
		List<Integer> lists=new ArrayList<>();
		lists.add(2);
		lists.add(3);
		lists.add(4);
		lists.add(5);
		List<Employee> list2 = emp.selectBatchIds(lists);
		list2.stream().forEach(System.out::println);
		System.out.println("sleectbatchids----:");
		Integer count = emp.selectCount(new EntityWrapper<Employee>());
		System.out.println(count+":-----selectCount---");
		List<Map<String,Object>> list3 = emp.selectMaps(new EntityWrapper<Employee>());
		list3.stream().forEach(System.out::println);
		System.out.println("selectMaps--------");
		List<Object> objs = emp.selectObjs(new EntityWrapper<>());
		objs.stream().forEach(System.out::println);
		System.out.println("selectObjs++++------:");
	}
	
	@Test
	public void test4(){
		List<Employee> list = emp.selectList(new EntityWrapper<Employee>().like("last_name", "wang"));
		list.stream().forEach(System.out::println);
		System.out.println("like-----");
		
		emp.selectList(new EntityWrapper<Employee>()
				.between("age", 20, 80).orderBy("age")
				.last("desc")).stream().forEach(System.out::println);
		System.out.println("between  ---orderBy-----desc");
		
		
		List<Employee> list2 = emp.selectList(new EntityWrapper<Employee>()
				.setSqlSelect(Columns.create().column("age", "年龄")));
		list2.stream().forEach(System.out::println);
		System.out.println("setSqlSelect-----");
		
		List<Object> list3 = emp.selectObjs(new EntityWrapper<Employee>()
				.setSqlSelect(Columns.create().column("last_name", "姓名")));
		list3.stream().forEach(System.out::println);
		
		
	}
	
	@Test
	public void test5(){
		emp.selectMaps(new EntityWrapper<Employee>()
				.setSqlSelect(Columns.create().column("last_name", "姓名")
						.column("age", "年龄"))
				.orderBy("age")
				.last("desc")).stream().forEach(System.out::println);
		emp.selectMapsPage(new Page<>(0,3),
				new EntityWrapper<Employee>()
				.setSqlSelect(Columns.create().column("last_name", "姓名")
						.column("age", "年龄"))
				.orderBy("age")
				.last("desc")).stream().forEach(System.out::println);
		
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test6(){
		List<Employee> list = emp.selectPage(new Page<Employee>(0,100), Condition.create()
				.between("age", 500, 1000));
		list.stream().forEach(System.out::println);
		
	}

}
