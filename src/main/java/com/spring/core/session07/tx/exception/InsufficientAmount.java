package com.spring.core.session07.tx.exception;

// 餘額不足
public class InsufficientAmount extends RuntimeException {

	public InsufficientAmount(String message) {
		super(message);
	}
	
}
