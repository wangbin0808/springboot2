package com.jrj.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jrj.springboot.bean.Dept;

@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@RequestMapping("/list")
	public List<Dept> test1(){
		Dept dept=new Dept();
		return dept.selectAll();
	}
	
	
	@RequestMapping("/gender")
	public List<Dept> test2(){
		Dept dept=new Dept();
		dept.setGender(1);
		return dept.selectAll();
	}
	
	@RequestMapping("/page")
	public List<Dept> test3(){
		Dept dept=new Dept();
		return dept.selectPage(new Page<Dept>(0,2),
				new EntityWrapper<Dept>().between("age", 20, 30)).getRecords();
	}
	
	@RequestMapping("/delect")
	public List<Dept> test4(){
		Dept dept=new Dept();
		dept.setId(1);
		dept.deleteById();
		return dept.selectAll();
	}

}
