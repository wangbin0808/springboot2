package com.jrj.springboot.dao;

import org.apache.ibatis.annotations.CacheNamespace;

import com.jrj.springboot.bean.User;

import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@CacheNamespace
public interface UserDao extends Mapper<User>{

}
