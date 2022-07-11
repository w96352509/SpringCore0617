package com.spring.core.session06.template;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Dao = Data Access Object (資料存取物件)

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; // 綁定 id 名稱
	
	// 多筆查詢
	public List<Map<String, Object>> queryAll(){
		String sql = "select eid , ename , age , createtime from emp ";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}
	
	
}
