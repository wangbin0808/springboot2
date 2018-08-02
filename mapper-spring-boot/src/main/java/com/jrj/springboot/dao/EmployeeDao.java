package com.jrj.springboot.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.junit.Assert;

import com.jrj.springboot.bean.Employee;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * @author bin.wang
 * @CacheNamespace在只使用接口的时候，添加缓存，只需要加这个注解就可以了,
 * 在添加的时候需要注意，一定把缓存的对象实现序列化接口
 * 
 * @org.apache.ibatis.annotations.Mapper这个注解在没有在启动类上面添加
 * @tk.mybatis.spring.annotation.MapperScan这个注解的时候一定要添加Mapper
 * 注解Mybatis才能识别
 * 
 * 官网：https://github.com/abel533/Mapper/wiki/faq
 *
 */
@org.apache.ibatis.annotations.Mapper
@CacheNamespace
public interface EmployeeDao extends Mapper<Employee>{
	/**
	 * @Param("em")当添加这个的时候，一定在取值的时候是em.属性
	 * 这个方法在插入数据后可以返回主键的值
	 * @param employee
	 * @return
	 */
	@Insert("insert into tabple_emp ( emp_id,emp_name,emp_salary,emp_age )"
			+ " values(null,#{empName},#{empSalary},#{empAge})")
	@Options(useGeneratedKeys=true,keyProperty="empId",keyColumn="emp_id")
	int insertReturnId(Employee employee);
	
    //这个示例适合参考实现对乐观锁方法封装
    default void updateSuccess(Employee country){
        Assert.assertEquals(1, updateByPrimaryKey(country));
    }
    
    default int deleteWithVersion(Employee t){
        int result = delete(t);
        if(result == 0){
          throw new RuntimeException("删除失败!");
        }
        return result;
      }

}
