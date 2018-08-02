package com.jrj.springboot.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.springboot.bean.Address;
import com.jrj.springboot.bean.StateEnum;
import com.jrj.springboot.bean.User;
import com.jrj.springboot.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserDao dao;
	@Test
	public void test1(){
		dao.selectAll().stream().forEach(System.out::println);;
	}
	
	@Test
	public void test2(){
		User user=new User();
		user.setName("wangbin");
		user.setState(StateEnum.enabled);
		user.setAddress(new Address("beijing","bjshi"));
		dao.insert(user);
	}

}
