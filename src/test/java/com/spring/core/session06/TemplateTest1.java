package com.spring.core.session06;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.template.EmpDao;

public class TemplateTest1 {

	@Test
	public void test() {
		// XML 配置
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		
		// JAVA 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
		EmpDao empDao = ctx.getBean("empDao",EmpDao.class);
		List<Map<String, Object>> emps = empDao.queryAll();
		System.out.println(emps);
	}
	
}
