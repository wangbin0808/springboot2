package com.jrj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 在这个地方要注意的地方是：扫描注解，一定要使用@tk.mybatis.spring.annotation.MapperScan
 * 而不是@MapperScan，
 * @author bin.wang
 *
 */
//@tk.mybatis.spring.annotation.MapperScan(basePackages={"com.jrj.springboot.dao"
//		,"com.jrj.springboot.dao.em"
//})
@SpringBootApplication
public class MapperSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapperSpringBootApplication.class, args);
	}
}
