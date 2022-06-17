package com.spring.core.session01;

import org.junit.Test;

import com.spring.core.session01.beans.Hello;

public class TestHello {

	@Test
	public void test() {

		// 傳統上建立 Hello 物件
		Hello h1 = new Hello();
		System.out.println(h1);
		
	}
}
