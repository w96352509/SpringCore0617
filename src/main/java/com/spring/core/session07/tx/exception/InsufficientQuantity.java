package com.spring.core.session07.tx.exception;

// 庫存不足
public class InsufficientQuantity extends RuntimeException {

	public InsufficientQuantity(String message) {
		super(message);
	}
	
}
