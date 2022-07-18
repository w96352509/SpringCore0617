package com.spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	/*
	 *   Propagation.REQUIRED(預設) : 如果有事務在運行,當前方法就在該事務運行,否則就啟動新的事物,並在自己得事務中運行
	 *   Propagation.REQUIRES_NEW   : 當前方法必須啟動新得事務 , 並自己得事務內運行 , 如果之前有事務正在運行就會將他掛起不用 
	 *   
	 * */
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity {
		// 減去一本庫存
		bookDao.updateStock(bid, 1);
		// 取得書籍價格
		Integer price = bookDao.getPrice(bid);
		// 減去錢包裡的錢
		bookDao.updateWallet(wid, price);
	}
}
