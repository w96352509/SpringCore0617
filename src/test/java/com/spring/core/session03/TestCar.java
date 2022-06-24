package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Car;

public class TestCar {

	@Test
	public void Test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = ctx.getBean("carFactory" , Car.class);
		System.out.println(car);
	}
	
}
