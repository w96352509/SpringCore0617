package com.spring.core.session04.sta;

import java.util.Random;

// 靜態代理
// 代理執行任務
public class PersonProxy implements Person {
	// 代理對象
	private Person person;

	public PersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public void work() {
		// before : 公用邏輯
		System.out.println("戴口罩");
		// 代理執行方法
		try {
			person.work();
		
		} catch (Exception e) {
			// 例外共用方法
		    System.out.println("去買口罩");
		    // 遞迴
		    person.work();
		}
		
		// end 
		System.out.println("脫口罩");
	}
}
