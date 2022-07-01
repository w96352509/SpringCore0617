package com.spring.core.session05.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面程式

@Component // 可以被 Spring 管理的物件
@Aspect    // 切面
@Order(1)  // 順序 數字越小越先執行 , 預設 = int 最大值 
           // 使用時機 : 有多個切面程式 , 在同一個橫切關注點(方法)要執行時
public class MyLoggerAspect {

  	// 前置(Before) 通知(Advice)
	// joinpoint 連結點
	// 切入點表達式 Spring EL : execution(..)
	//@Before(value = "execution(public Integer com.spring.core.session05.aop.MathCalcImpl.add(Integer,Integer));")
	// *任意方法 ..任意參數(但不會取空參數) 
	@Before(value = "execution(public Integer com.spring.core.session05.aop.MathCalcImpl.*(..));") 
	public void beforeAdvice(JoinPoint joinPoint) {
		// 取得連接點方法(方法簽章)名稱
		String methodName = joinPoint.getSignature().getName();
		// 方法參數
	    Object[] args = joinPoint.getArgs();
	    System.out.printf("前置通知 : 方法名稱 %s 參數%s \n" , methodName , args);
	}
}
