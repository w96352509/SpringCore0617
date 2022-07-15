package com.spring.core.session06;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.template.EmpDao;

public class TemplateTest4 {
	@Test
	public void test() {
		// 使用 xml 配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		int[] rowcounts = empDao.addTwo("z03", 3, "z05", 5);
		//System.out.println(Arrays.toString(rowcounts));
		System.out.println(empDao.queryAll());
		
	}
}