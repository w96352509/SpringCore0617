package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session05.aop.MathCalc;
import com.spring.core.session05.aop.MathCalcImpl;

public class AOPTest {
	@Test
	public void test() {
		// XML 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		MathCalc calc = ctx.getBean("mathCalcImpl", MathCalcImpl.class);
		System.out.println(calc.add(20, 10));
		System.out.println(calc.div(20, 0));
		// Java 配置
		/*
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(AOPConfig.class);
		MathCalc calc2 = ctx2.getBean(MathCalc.class);
		System.out.println(calc2.add(20, 10));
		System.out.println(calc2.div(20, 10));
		*/
	}
}
