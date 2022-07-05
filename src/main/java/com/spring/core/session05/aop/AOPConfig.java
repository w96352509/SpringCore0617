package com.spring.core.session05.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring.core.session05.aop_lab.Audience;
import com.spring.core.session05.aop_lab.Dancer;
import com.spring.core.session05.aop_lab.Introducter;
import com.spring.core.session05.aop_lab.Performance;

@Configuration // 此為 Java 配置檔
//@ComponentScan(basePackages = {"com.spring.core.session04", "com.spring.core.session03"}) // 啟用元件掃描(指定掃瞄路徑)
@ComponentScan // 啟用元件掃描(掃瞄有 @ 註解的元件, 目的是交由 String 來管理)
@EnableAspectJAutoProxy // 自動生成代理物件
public class AOPConfig {
	
	@Bean(name = "dancer")
	public Performance dancer() {
		Dancer dancer = new Dancer();
		return dancer;
	}
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public Introducter getIntroducter() {
		return new Introducter();
	}
}
