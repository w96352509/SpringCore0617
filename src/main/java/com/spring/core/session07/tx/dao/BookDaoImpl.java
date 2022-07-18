package com.spring.core.session07.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.core.session07.tx.exception.InsufficientAmount;
import com.spring.core.session07.tx.exception.InsufficientQuantity;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPrice(Integer bid) {
		String sql = "select price from book where bid=?";
		// 將結果(type Object) 轉 其他 type.class
		return jdbcTemplate.queryForObject(sql,Integer.class,bid);
	}

	@Override
	public Integer getStockAmount(Integer bid) {
		String sql = "select amount from stock where bid = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class , bid);
	}

	@Override
	public Integer getWallentMoney(Integer wid) {
	    String sql = "select money from wallet where wid=?";
	    return jdbcTemplate.queryForObject(sql, Integer.class , wid);
	}

	@Override
	public Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity {
		// 確認該書最新順存量
		Integer new_amount = getStockAmount(bid);
		if (new_amount <= 0) {
			throw new InsufficientQuantity(String.format("此書號：%d 目前沒庫存，目前數量：%d", bid, new_amount));
		}else if(new_amount < amount) {
			throw new InsufficientQuantity(String.format("此書號：%d 目前庫存不足，目前數量：%d，欲購買數量：%d", bid, new_amount, amount));
		}
		String sql = "update stock set amount = amount -? where bid = ?";
		return jdbcTemplate.update(sql , amount , bid);
	}

	@Override
	public Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount {
		Integer new_money = getWallentMoney(wid);
		if(new_money <=0) {
			throw new InsufficientAmount(String.format("錢包號碼 : %d 餘額為0 , 目前餘額 : %d" , wid , money));
		}else if (new_money < money) {
			throw new InsufficientAmount(String.format("錢包號碼：%d 餘額不足，目前餘額：$ %d，欲扣款金額：$ %d", wid, new_money, money));
		}
		String sql = "update wallet set money = money - ? where wid =?";
		return jdbcTemplate.update(sql, money , wid);
	}

	@Override
	public String getName(Integer bid) {
	    String sql = "select bname from book where bid = ?";
		return jdbcTemplate.queryForObject(sql,String.class,bid);
	}

	@Override
	public String getWallentName(Integer wid) {
		String sql ="select wname from wallet where wid=?";
		return jdbcTemplate.queryForObject(sql,String.class, wid);
	}
	
	
}
