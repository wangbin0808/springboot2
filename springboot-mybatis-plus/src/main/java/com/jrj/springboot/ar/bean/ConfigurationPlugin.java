package com.jrj.springboot.ar.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import com.jrj.springboot.bean.MyMetaObjectHandler;
import com.jrj.springboot.bean.MySqlInjector;
/**
 * 
 * @author bin.wang
 * 分页插件
 *
 */
@EnableTransactionManagement
@Configuration
public class ConfigurationPlugin {
	/**
	 * 分页插件
	 * @return
	 */
	@Bean
	public PaginationInterceptor create(){
		return new PaginationInterceptor();
	}
	
	/**
	 * 拦截删除全表的操作--setStopProceed这个要设置成true,
		SQL 执行分析拦截器【 目前只支持 MYSQL-5.6.3 以上版本 】，
		作用是分析 处理 DELETE UPDATE 语句， 防止小白或者恶意 delete update 全表操作！
	 * @return
	 */
	@Bean
	public SqlExplainInterceptor createSqlExplainInterceptor(){
		SqlExplainInterceptor interceptor = new SqlExplainInterceptor();
		interceptor.setStopProceed(true);
		return interceptor;
	}
	/**
	 * 性能分析插件
	 * @return
	 */
	//@Profile({"dev","test","pr"})
	@Bean
	public PerformanceInterceptor createPerformanceInterceptor(){
		PerformanceInterceptor interceptor = new PerformanceInterceptor();
		interceptor.setMaxTime(100);//设置sql查询的最大时间，超过时间的话就会中断
		interceptor.setFormat(true);//当设置成true的时候就会格式化sql
		return interceptor;
	}
	/**
	 * 乐观锁插件，这个也要在数据库添加一个字段来当version版本记录，也需要在属性里上面添加一个注解@version
	 * @return
	 */
	@Bean
	public OptimisticLockerInterceptor  createOptimisticLockerInterceptor(){
		return new OptimisticLockerInterceptor ();
	}

	/**
	 * 这个是自己添加方法
	 * @return
	 */
	@Bean
	public MySqlInjector createMySqlInjector(){
		return new MySqlInjector();
	}
	/**
	 * 公共字段自动填充
	 * @return
	 */
	@Bean
	public MyMetaObjectHandler createMyMetaObjectHandler(){
		return new MyMetaObjectHandler();
	}
	


}
