package com.spring.core.session07.tx.exception;

// 餘額不足
// Exception 強制拋出例外
public class InsufficientAmount extends Exception {

	public InsufficientAmount(String message) {
		super(message);
	}
	
}
