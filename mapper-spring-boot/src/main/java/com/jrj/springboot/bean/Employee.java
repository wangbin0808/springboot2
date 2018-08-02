package com.jrj.springboot.bean;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.Version;

@Table(name="tabple_emp")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@KeySql(useGeneratedKeys=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	private Double empSalary;
	private Integer empAge;
	
	@Version
	private Integer version;
	public Employee(Integer empId, String empName, Double empSalary, Integer empAge, Integer version) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.version = version;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
				+ ", version=" + version + "]";
	}
	public Employee(Integer empId, String empName, Double empSalary, Integer empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}
	public Employee() {

	}
	

}
