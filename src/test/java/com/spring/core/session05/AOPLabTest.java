package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session05.aop.AOPConfig;
import com.spring.core.session05.aop.MathCalc;
import com.spring.core.session05.aop.MathCalcImpl;
import com.spring.core.session05.aop_lab.Performance;
import com.spring.core.session05.aop_lab.Singer;

public class AOPLabTest {
	@Test
	public void test() {
		// Java 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		try {
			dancer.perform(); // 舞者表演
		} catch (Exception e) {
			System.out.println(e); // 意外發生
			// 舞者轉換跑道
			// 改行去唱歌
			// dancer 透過 introducter(經紀人) 轉換跑道
			System.out.println("舞者轉歌者");
			Singer singer = (Singer) dancer;
			singer.sing();
		}
		
	}
}
