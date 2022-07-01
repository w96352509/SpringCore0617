package com.spring.core.session04.dyn;

import java.util.Arrays;

// Aspect 切面 (公用邏輯)
public class MyLogger {
	// Before 前置通知(業務方法調用前執行)
	public static void before(Class cls, String methodName, Object[] args) {
		System.out.printf("前置通知: %s , %s ,args=%s \n", cls, methodName, Arrays.toString(args));
	}

	// Exception 例外異常通知
	public static void throwing(Class cls, Throwable throwable) {
		System.out.printf("異常通知: %s , %s  \n", cls, throwable);
	}
	// End 後置通知(業務方法調用完畢後執行)
	public static void end(Class cls, String methodName, Object result) {
		System.out.printf("後置通知: %s , %s , result=%s", cls, methodName, result);
	}
}
