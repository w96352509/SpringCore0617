package com.spring.core.session07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session07.tx.controller.BookController;
import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

public class BookTest {

	@Test
	public void test() throws InsufficientQuantity , InsufficientAmount {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean(BookController.class);
		bookController.buyBook(1, 1);
	}
	
}
