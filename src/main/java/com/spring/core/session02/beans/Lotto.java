package com.spring.core.session02.beans;

import java.util.Random;

public class Lotto {

	private Integer number;

	public Lotto() {
		Random random = new Random();
		number = random.nextInt(100) +1;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Lotto [number=" + number + "]";
	}
	
	
	
	
	
}
