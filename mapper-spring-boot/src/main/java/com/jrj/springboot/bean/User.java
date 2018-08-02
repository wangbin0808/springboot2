package com.jrj.springboot.bean;

import java.io.Serializable;

import javax.persistence.Id;

import com.jrj.springboot.handler.AddressTypeHandler;
import com.jrj.springboot.handler.StateEnumTypeHandler;

import tk.mybatis.mapper.annotation.ColumnType;

public class User  implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer   id;
    private String    name;
    @ColumnType(typeHandler = AddressTypeHandler.class)
  //  @Column
    private Address   address;
    
    @ColumnType(typeHandler = StateEnumTypeHandler.class)
   // @Column
    private StateEnum state;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", state=" + state + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public StateEnum getState() {
		return state;
	}
	public void setState(StateEnum state) {
		this.state = state;
	}
	public User(Integer id, String name, Address address, StateEnum state) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.state = state;
	}
	public User() {

	}
    
    

}
