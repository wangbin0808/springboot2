package com.jrj.springboot.bean;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

public class MyMetaObjectHandler extends MetaObjectHandler{

	@Override
	public void insertFill(MetaObject metaObject) {
		System.out.println("在插入是如果name的值为空时，可以插入值");
		Object name = getFieldValByName("lastName", metaObject);
		System.out.println(name);
		if(name==null){
			setFieldValByName("lastName", "wangbin", metaObject);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		
		
	}

}
