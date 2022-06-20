package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Lotto;
import com.spring.core.session02.conf.Lottoconfig;

public class TestLotto {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 此用法僅限於在設定檔中只有一個實例時使用(不可有兩個ID)
		// Lotto lotto = ctx.getBean(Lotto.class);
		Lotto lotto_a = ctx.getBean("lotto",Lotto.class);  // p
		Lotto lotto_b = ctx.getBean("lotto",Lotto.class);  // p
		Lotto lotto_c = ctx.getBean("lotto2",Lotto.class); // s
		Lotto lotto_d = ctx.getBean("lotto2",Lotto.class); // s
	    System.out.println(lotto_a);
	    System.out.println(lotto_b);
	    System.out.println(lotto_c);
	    System.out.println(lotto_d);
	    
	    
	    
	    // Java 配置
	    ApplicationContext ctx2 = new AnnotationConfigApplicationContext(Lottoconfig.class);
	    Lotto lotto2 = ctx2.getBean("lotto" , Lotto.class);
	    System.out.println("Java配置"+lotto2);
	}
	
}
