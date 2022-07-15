package com.spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity {
	   // 減去一本庫存
	   bookDao.updateStock(bid, 1);
	   // 取得書集價格
	   Integer price = bookDao.getPrice(bid);
	   // 減去錢包數量
	   bookDao.updateWallet(wid , price);
	  }

	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientAmount, InsufficientQuantity {
		for(Integer bid : bids ) {
			buyOne(wid, bid);
		}
	}

}
