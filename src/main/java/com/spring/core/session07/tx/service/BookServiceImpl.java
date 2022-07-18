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
	   System.out.println("購買書名:" + bookDao.getName(bid));
	   System.out.println("購買價格:" + price);
	   System.out.println("剩餘數量:" + bookDao.getStockAmount(bid));
	   System.out.println("購買者:"+bookDao.getWallentName(wid)+"剩餘金額:" + bookDao.getWallentMoney(wid));  
	}


}
