package com.spring.core.session02.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.session02.beans.Lotto;

@Configuration
public class Lottoconfig {

	@Bean(name="lotto")
	public Lotto getLotto() {
		Lotto lotto = new Lotto();
		return lotto;
	}
	
}
