package com.spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.core.session07.tx.dao.BookDao;
import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW , isolation = Isolation.READ_COMMITTED) // DEFAULT 看資料庫本身
	/*   // 事務 = @tx 方法 / 掛起 = 不用
	 *   Propagation.REQUIRED(預設) : 如果有事務在運行 , 當前方法就在該事務運行,否則就啟動新的事物,並在自己得事務中運行
	 *   
	 *   Propagation.REQUIRES_NEW   : 當前方法必須啟動新得事務 , 並自己得事務內運行 , 如果之前有事務正在運行就會將他掛起(不用) 
	 *   
	 *   Propagation.SUPPORTS       : 如果有事物在運行 , 當前方就在此事務中運行 , 否則就不在此事務中 
	 *   Propagation.NOT_SUPPERTED  : 當前方法不該在事務中運行 , 如果有事物就會將他掛起(不用) 
	 *   
	 *   Propagation.MANDATORY      : 當前方法必須運行在事務中 , 若無則拋出異常
	 *   Propagation.NEVER          : 當前方法不應該運行在事務中 , 若在事務中則拋出異常
	 *   Propagation.NESTED         : 如果有事物在運行 , 當前方法必須嵌套在事務中 , 否則新建一個事務 
	 *   
	 *   Isolation                  : 事務的隔離級別 , 在併發的情況下 , 操作數據 CRUD 的一種規則
	 *   Isolation.Default          : 預設(看資料庫本身) mysql -> 可重複讀
	 *   
	 *   // 表 , 欄位
	 *   Isolation.READ_UNCOMMITTED 讀未提交 : 會發生髒讀(針對欄位資料)
	 *   Isolation.READ_COMMITTED   讀已提交 : 不可重複讀(針對欄位資料)
	 *   Isolation.REPEATABLE_READ  可重複讀 : 幻讀 > 其他人不可以針對指定資料列 CRUD (針對列(多個欄位))
	 *   Isolation.SERIALIZABLE     序列化   : 效能低 , 消耗大 , 簡單解決以上所有問題 , 實務上不建議使用(針對表)  
	 *    
	 */
	
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
