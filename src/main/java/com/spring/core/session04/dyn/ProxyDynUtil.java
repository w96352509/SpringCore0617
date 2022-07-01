package com.spring.core.session04.dyn;

import java.lang.reflect.Proxy;

// 動態代理工具
public class ProxyDynUtil {

	// 代理的對件
	private Object object;
	
	// 將代理物件注入
	public ProxyDynUtil(Object object) {
		this.object = object;
	}
	
	// 取得代理對件
	public Object getProxy() {
		Object proxyObj = null;
		proxyObj = Proxy.newProxyInstance(loader, interfaces, invocationHandler);
		return proxyObj;
	}
	
}
