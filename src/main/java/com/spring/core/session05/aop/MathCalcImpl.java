package com.spring.core.session05.aop;

import org.springframework.stereotype.Component;

@Component
public class MathCalcImpl implements MathCalc {

	@Override
	public Integer add(Integer x, Integer y) {
		Integer result = x + y;
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		Integer result = x / y;
		return result;
	}

	
}
