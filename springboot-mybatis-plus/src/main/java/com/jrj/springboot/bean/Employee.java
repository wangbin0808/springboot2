package com.jrj.springboot.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@TableName(value="tbl_employee")
public class Employee {

//	@TableId(type=IdType.AUTO,value="id")
	private Integer id ;   //  int 
	
//	@TableField(value = "last_name")
	private String  lastName; 
	private String  email ;
	private Integer gender; 

	private Integer age ;
	@Version
	private Integer version;
	public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;

	}
	
	
}
