package com.spring.core.session06.template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.core.session06.entity.Emp;

// Dao = Data Access Object (資料存取物件)

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; // 綁定 id 名稱
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	// 多筆查詢
	public List<Map<String, Object>> queryAll(){
		String sql = "select eid , ename , age , createtime from emp ";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}
	
	// 多筆查詢 2 
	public List<Emp> queryAllEmp(){
		String sql = "select eid , ename , age , createtime from emp ";
		RowMapper<Emp> rowMapper = (ResultSet rs, int rowNum)->{
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreatetime(rs.getTimestamp("createtime"));
			return emp;
		};
	    List<Emp> emps = jdbcTemplate.query(sql, rowMapper);
	    return emps;
	}
	
	// 多筆查詢 3 (Bean 的名稱對應資料庫欄位名稱)
	public List<Emp> queryAllEmp2(){
		String sql = "select eid, ename, age, createtime from emp";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Emp.class));
	}
	
	// 單筆新增 1
	public int add(String ename , Integer age) {
		String sql = "insert into emp(ename , age) value(?,?)";
		int rowcount = jdbcTemplate.update(sql,ename,age);
		return rowcount;
	}
	
	// 單筆新增 2
	public int add2(String ename , Integer age) {
		String sql = "insert into emp(ename, age) values(:ename, :age)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ename", ename);
		params.addValue("age",   age);
		int rowcount = namedParameterJdbcTemplate.update(sql, params);
		return rowcount; 
	}
	
	// 多筆新增
	public int[] multiAdd(List<Object[]> rows) {
		String sql = "insert into emp(ename , age) value(?,?)";
		return jdbcTemplate.batchUpdate(sql , rows);
	}
	
	// 多筆新增 2
	public int[] multiAdd2(List<Emp> emps) {
		String sql = "insert into emp(ename , age) value(?,?)";
	    BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// i = emps 的 index
				// (設定 i 值 , emps.get(i).get...())
				ps.setString(1, emps.get(i).getEname());
		        ps.setInt(2, emps.get(i).getAge());		
				
			}
			
			@Override
			public int getBatchSize() {
				return emps.size();
			}
		};
		return jdbcTemplate.batchUpdate(sql,setter);
	}
	
	// 修改
	public int updateById(Integer eid , String ename , Integer age) {
		String sql = "update emp set ename=?, age=? where eid=? ";
		return jdbcTemplate.update(sql,ename,age,eid);
	}
	
	// 刪除
	public int deleteById(Integer eid) {
		String sql = "delete from emp where eid=?";
		return jdbcTemplate.update(sql,eid);
	}
	
	// 取得單筆資料
	public Emp getEmpById(Integer eid) {
		String sql = "select eid, ename, age, createtime from emp where eid=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class),eid);
	}
	
}
