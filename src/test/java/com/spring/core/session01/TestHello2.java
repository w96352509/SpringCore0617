package com.spring.core.session01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.beans.Hello;

public class TestHello2 {

	@Test
	public void test() {
		// 利用 spring 來取得所建立的 hello 物件
		// xml 配置 : conf -> applicationContext.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    Hello hello = (Hello)ctx.getBean("hello");
	    System.out.println(hello);
        Hello hello2 = ctx.getBean("hello" , Hello.class);
        System.out.println(hello2);
	}
	
}
