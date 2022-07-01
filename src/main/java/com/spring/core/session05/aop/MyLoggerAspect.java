package com.spring.core.session05.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面程式

@Component // 可以被 Spring 管理的物件
@Aspect    // 切面
@Order(1)  // 順序 數字越小越先執行 , 預設 = int 最大值 
           // 使用時機 : 有多個切面程式 , 在同一個橫切關注點(方法)要執行時
public class MyLoggerAspect {

	
	
}
