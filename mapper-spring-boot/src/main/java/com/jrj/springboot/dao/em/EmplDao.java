package com.jrj.springboot.dao.em;

import org.apache.ibatis.annotations.CacheNamespace;

import com.jrj.springboot.bean.Employee;

import tk.mybatis.mapper.common.Mapper;
/**
 * 
 * @author bin.wang
 * 测试二级缓存，结果没有测试成功，
 * @CacheNamespace在只使用接口的时候，添加缓存，只需要加这个注解就可以了,
 * 在添加的时候需要注意，一定把缓存的对象实现序列化接口
 * 官方文档上也没有讲原因
 *
 */
@org.apache.ibatis.annotations.Mapper
@CacheNamespace
public interface EmplDao extends Mapper<Employee>{

}
