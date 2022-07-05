package com.spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introducter { // 經紀人
	// 將 Performance 及其子類別可以轉為 Singer
	@DeclareParents(value = "com.spring.core.session05.aop_lab.Performance+",
					defaultImpl = BackSinger.class)
	public Singer singer;
}
