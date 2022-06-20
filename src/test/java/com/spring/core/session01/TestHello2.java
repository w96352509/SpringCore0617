package com.spring.core.session01;

import javax.xml.transform.Source;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.beans.Hello;
import com.spring.core.session01.conf.SpringConfig;

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
        
        // Java 配置 : SpringConfig.java
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(SpringConfig.class);
        Hello hello3 = ctx2.getBean(Hello.class);
        System.out.println(hello3);
        Hello hello4 = ctx2.getBean("hello",Hello.class);
        System.out.println(hello4);
	}
	
}
