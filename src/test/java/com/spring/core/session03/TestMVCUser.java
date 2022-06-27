package com.spring.core.session03;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.mvc.controller.UserController;
import com.spring.core.session03.mvc.model.User;

public class TestMVCUser {

	
	
	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = ctx.getBean("user" , User.class); // 預設ID 首字小寫
		System.out.println(user);
		
		// 將 User 加入集合內
		UserController userController = ctx.getBean("userController",UserController.class);
		userController.appendUser(user);
		
	}
	
}
