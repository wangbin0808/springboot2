package com.jrj.springboot.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class Dept  extends Model<Dept>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer id ;   //  int 
	

	@TableField(fill=FieldFill.INSERT)
	private String  lastName; 
	private String  email ;
	private Integer gender; 
	private Integer age ;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	@TableField("version")
	@TableLogic
	private int version;
	public Dept(Integer id, String lastName, String email, Integer gender, Integer age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	
	public Dept() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", age=" + age
				+ "]";
	}

	@Override
	protected Serializable pkVal() {
		
		return id;
	}
}
