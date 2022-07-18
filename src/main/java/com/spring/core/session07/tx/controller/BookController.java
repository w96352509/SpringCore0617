package com.spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;
import com.spring.core.session07.tx.service.BookService;
import com.spring.core.session07.tx.service.ManyBookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ManyBookService manyBookService;
	
	public void buyBook(Integer wid , Integer bid) {
		try {
			bookService.buyOne(wid, bid);
			System.out.println("購買單筆");
		} catch (InsufficientAmount e) {
			e.printStackTrace();
			System.out.println("庫存不足:" + e);
		} catch (InsufficientQuantity e) {
			e.printStackTrace();
			System.out.println("金額不足:" + e);
		}
		
	}
	
	public void buyBooks(Integer wid , Integer... bids) {
		try {
			manyBookService.buyMany(wid, bids);
		} catch (InsufficientAmount e) {
			e.printStackTrace();
			System.out.println("庫存不足 :" + e);
		} catch (InsufficientQuantity e) {
			e.printStackTrace();
			System.out.println("金額不足 :" + e);
		}
	}
}
