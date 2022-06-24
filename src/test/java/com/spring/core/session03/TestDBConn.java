package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.DBConn;

public class TestDBConn {

	@Test
	public void Test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConn dbConn = ctx.getBean("dbconn" , DBConn.class);
		System.out.println(dbConn);
		dbConn.query();
		dbConn.query();
		
		// 關閉 ApplicationContext 環境
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
}
