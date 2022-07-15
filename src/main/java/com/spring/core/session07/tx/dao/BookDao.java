package com.spring.core.session07.tx.dao;

import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

public interface BookDao {
   Integer getPrice(Integer bid);
   Integer getStockAmount(Integer bid);
   Integer getWallentMoney(Integer wid);
   Integer updateStock(Integer bid , Integer amount) throws InsufficientQuantity; 
   Integer updateWallet(Integer wid , Integer money) throws InsufficientAmount;
   
}
