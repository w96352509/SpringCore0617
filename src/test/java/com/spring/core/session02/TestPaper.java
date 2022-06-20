package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Paper;
import com.spring.core.session02.beans.WhiteA4;


public class TestPaper {

	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 Paper paper2 = ctx.getBean("paper2" , Paper.class );
		 WhiteA4 paper3 = ctx.getBean("paper3" , WhiteA4.class);
		 Paper paper4 = ctx.getBean("paper4" , Paper.class );
		 System.out.println(paper2);
		 System.out.println(paper3);
		 System.out.println(paper4);
	     
       		 
}
	
}
