package com.jrj.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.entity.Columns;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jrj.springboot.bean.Employee;
import com.jrj.springboot.dao.EmployeeMapper;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeMapper emp;
	
	@RequestMapping("/list")
	public List<Employee> getList(){
		return emp.selectList(new EntityWrapper<Employee>());
	}
	
	@RequestMapping("/insertOne")
	public String insertOne(){
		Employee e=new  Employee(null, "wangbin", "wangbin@jrj.com.cn"
				, 1, 20);
		Integer insert = emp.insert(e);
		System.out.println(insert);
		Employee e1=new  Employee(null, "wangbin1", "wangbin1@jrj.com.cn"
				, 1, 201);
		Integer column = emp.insertAllColumn(e1);
		System.out.println(column+"--"+e1.getId());
		return "1";
	}
	
	
	@RequestMapping("/update")
	public String update(){
		Employee e=new  Employee(2, "wang", "wang@jrj.com.cn"
				, 1, 20);
		//updateAllColumnById这个是修改所有的字段
		Integer byId = emp.updateAllColumnById(e);
		System.out.println(byId);
		return "1";
	}
	
	@RequestMapping("/updateOne")
	public String updateOne(){
		Employee e=new  Employee();
		e.setId(3);
		e.setAge(10000);
		//updateById这个会进行字段的判断
		Integer byId = emp.updateById(e);
		System.out.println(byId);
		return "1";
	}
	
	@RequestMapping("/remove")
	public String remove(){

		emp.deleteById(1);
		return "1";
	}
	
	
	@RequestMapping("/select/{id}")
	public Employee select(@PathVariable int id){

		return emp.selectById(id);
	}
	
	
	@RequestMapping("/selectByid")
	public List<Employee> select(){

		List<Integer> idList=new ArrayList<>();
		idList.add(2);
		idList.add(3);
		idList.add(4);
		List<Employee> list = emp.selectBatchIds(idList);
		return list;
	}
	
	@RequestMapping("/selectMap")
	public List<Employee> selectMap(){


		Map<String,Object> map=new HashMap<>();
		map.put("last_name", "wangbin");
		map.put("gender", 1);
		List<Employee> list = emp.selectByMap(map);
		return list;
	}
	
	@RequestMapping("/selectpage")
	public List<Employee> selectpage(){
		RowBounds rowBounds=new RowBounds(0, 2);
		Wrapper<Employee> wrapper=null;
		List<Employee> list = emp.selectPage(rowBounds, wrapper);
		return list;
	}
	@RequestMapping("/selectmap")
	public List<Map<String,Object>> selectMapsPage(){
	
		return emp.selectMaps(new EntityWrapper<Employee>()
				.setSqlSelect(Columns.create().column("last_name", "姓名")
						.column("age", "年龄"))
				.orderBy("age")
				.last("desc"));
	}

}
