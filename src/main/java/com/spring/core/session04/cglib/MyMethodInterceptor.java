package com.spring.core.session04.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

// 方法攔截器 (cglib 使用)
public class MyMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("請出示實聯");
		return proxy.invokeSuper(obj, args);
	}

	
	
}
