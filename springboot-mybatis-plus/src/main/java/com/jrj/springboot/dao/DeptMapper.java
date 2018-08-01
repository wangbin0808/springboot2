package com.jrj.springboot.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jrj.springboot.bean.Dept;

public interface DeptMapper extends BaseMapper<Dept>{
	
	int deleteAll();

}
