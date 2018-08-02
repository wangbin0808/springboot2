package com.jrj.springboot.handler;

import org.apache.ibatis.type.EnumOrdinalTypeHandler;

import com.jrj.springboot.bean.StateEnum;
/**
 * 这个是枚举的类型处理类
 * @author bin.wang
 * 实现看官网：https://github.com/abel533/Mapper/wiki/7.2.typehandler
 *
 */
public class StateEnumTypeHandler extends EnumOrdinalTypeHandler<StateEnum>{

	public StateEnumTypeHandler(Class<StateEnum> type) {
		super(type);
	}

}
