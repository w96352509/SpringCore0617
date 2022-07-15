package com.spring.core.session07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

public class BookTest {

	@Test
	public void test() throws InsufficientQuantity , InsufficientAmount {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookDao bookDao = ctx.getBean(BookDao.class);
		// 書號 要減去數量
		bookDao.updateStock(1,20);
		// 錢包號碼 要減去金額
		bookDao.updateWallet(1, 400);
		System.out.println("書本金額" + bookDao.getPrice(1));
		System.out.println("庫存數量" + bookDao.getStockAmount(1));
		System.out.println("客戶金額" + bookDao.getWallentMoney(1));
		
	}
	
}
