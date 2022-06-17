package com.spring.core.session01.beans;
import java.util.Date;


public class Hello {

	public Hello() {
		System.out.println("物件建立");
	}
	
	@Override
	public String toString() {
		return "Hello Bean" + new Date();
	}
	
}
