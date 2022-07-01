package com.spring.core.session04;

import org.springframework.cglib.proxy.Enhancer;

import com.spring.core.session04.cglib.*;
import com.spring.core.session04.cglib.MyMethodInterceptor;

public class CglibTest {

	public void test() {
		// 使用 cglib
		// 1. 增強器
		Enhancer enhancer = new Enhancer();
		// 2. 要增強的對象
		enhancer.setSuperclass(Hello.class);
		// 3. 方法攔截器
		enhancer.setCallback(new MyMethodInterceptor());
		// 4.
		Hello hello = (Hello)enhancer.create();
		System.out.println(hello.sayHello("John"));
	}
	
}
