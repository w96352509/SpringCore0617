package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.Student;

public class TestClazz {

	@Test
	public void Test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Clazz clazz = ctx.getBean("clazz1",Clazz.class);
		Student student1 = ctx.getBean("student1" , Student.class);
		System.out.println(student1);
		System.out.println(clazz);
	}
	
}
