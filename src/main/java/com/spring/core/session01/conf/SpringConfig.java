package com.spring.core.session01.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring.core.session01.beans.Hello;

// Java 配置 
// 配置檔在可以new

@Configuration
public class SpringConfig {
    
	@Bean(name = "hello")
	@Scope("prototype")
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
	
}
