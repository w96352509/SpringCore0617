package com.spring.core.session06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTest {

	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		ComboPooledDataSource cp = ctx.getBean("dataSource" , ComboPooledDataSource.class);
		try {
			System.out.println(cp.getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
		  System.out.println("連線成功");
	}
	
}
