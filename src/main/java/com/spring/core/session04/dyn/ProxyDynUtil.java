package com.spring.core.session04.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

// 動態代理工具
public class ProxyDynUtil {

	// 代理的對件
	private Object object;
	
	// 將代理物件注入
	public ProxyDynUtil(Object object) {
		this.object = object;
	}
	
	// 取得代理物件
	public Object getProxy() {
		Object proxyObj = null;
		// 1. 類別載入器
		ClassLoader loader = object.getClass().getClassLoader();
		// 2. 代理物件所實作的介面
		Class[] interfaces = object.getClass().getInterfaces();
		// 3. 處理代理的實現
		InvocationHandler invocationHandler = ( proxy, method, args) ->{
			Object result = null;
			// Before : 前置通知
			System.out.println("Before: 前置通知");
			// 調用業務方法
			result = method.invoke(object, args);
			return result;
		};
		proxyObj = Proxy.newProxyInstance(loader, interfaces, invocationHandler);
		return proxyObj;
	}
	
}
