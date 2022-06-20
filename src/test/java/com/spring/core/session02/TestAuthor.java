package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Author;
import com.spring.core.session02.conf.AuthorConfig;


public class TestAuthor {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author1 = ctx.getBean("author1" , Author.class); // 多型
		Author author2 = ctx.getBean("author2" , Author.class); // 多型
		Author author3 = ctx.getBean("author3" , Author.class); // 多型
		Author author4 = ctx.getBean("author4" , Author.class); // 多型
		Author author5 = ctx.getBean("author5" , Author.class); // 多型
		// 手動注入
		author1.setName("john");
		author1.setSex('M');
		author1.setAge(18);
		System.out.println(author1);
		System.out.println("方法注入"          + author2);
		System.out.println("建構子注入"        + author3);
		System.out.println("方法注入(簡寫p)"   + author4);
		System.out.println("建構子注入(簡寫c)" + author5);
	    
	    // Java 配置
	    ApplicationContext ctxj = new AnnotationConfigApplicationContext(AuthorConfig.class);
	    Author authorj = ctxj.getBean("author" , Author.class);
	    System.out.println("Java配置"+authorj.toString());
	    
	    
	}
	
}
