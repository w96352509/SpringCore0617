package com.spring.core.session04;

import org.junit.Test;

import com.spring.core.session04.sta.Man;
import com.spring.core.session04.sta.Person;
import com.spring.core.session04.sta.PersonProxy;
import com.spring.core.session04.sta.WoMan;

public class ProxyStaticDemo {

	@Test
	public void test() {
		/*
		 * // 不透過代理直接執行 
		 * Person man = new Man(); 
		 * man.work(); 
		 * Person woMan = new WoMan();
		 * woMan.work();
		 */
	// 透過靜態代理
		Person man    = new PersonProxy(new Man());
		Person woman  = new PersonProxy(new WoMan());
		man.work();
		woman.work();
	}

}
