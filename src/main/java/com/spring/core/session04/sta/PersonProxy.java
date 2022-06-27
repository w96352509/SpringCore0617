package com.spring.core.session04.sta;

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
		// 公用邏輯
		System.out.println("戴口罩");
		// 代理執行方法
		person.work();
	}
}
