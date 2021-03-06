package com.spring.core.session06.template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.entity.Job;

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
	
	// Emp 一對多 Job 查詢
	public List<Emp> queryEmpAndJob(){
		String sql = "select  e.eid , e.ename , e.age , e.createtime, "
				   + "j.jid as job_jid ,j.jname as job_jname , j.eid as job_eid "
				   + "from emp e left join job j on j.eid = e.eid";
	    // j.jid as job_jid 命名 job_jid 表示將 jid 內容對應 job
		ResultSetExtractor<List<Emp>> resultSetExtractor = 
				 JdbcTemplateMapperFactory
				 .newInstance()
				 .addKeys("eid") // (單)主鍵
				 .newResultSetExtractor(Emp.class);
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	
	public List<Job> queryJobsAndEmp(){
		String sql ="select  j.jid ,j.jname ,j.eid, "
				   +"e.eid as emp_eid , e.ename as emp_ename , e.age as emp_age , e.createtime as emp_createtime "
				   +"from job j left join emp e on e.eid = j.eid ";
		ResultSetExtractor<List<Job>> resultSetExtractor = 
				JdbcTemplateMapperFactory
				.newInstance()
				.addKeys("jid") // 主鍵(primary key)
				.newResultSetExtractor(Job.class);
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	
	// 同時新增兩筆資料
	public int[] addTwo(String ename1 , Integer age1 , String ename2 , Integer age2 ) {
		int[] rowcount = new int[2];
	    // 建立事務管理 TransactionManager
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		
		// 定義 TransactionDefinition 
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		// 設定交易傳播
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		// 交易狀態
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			// 資料庫預讀(不完全存入)
			String sql = "insert into emp(ename , age) values(?,?)";
		    rowcount[0] = jdbcTemplate.update(sql,ename1,age1);
		    rowcount[1] = jdbcTemplate.update(sql,ename2,age2);	
		} catch (Exception e) {
			// 回滾
			transactionManager.rollback(status);
		    e.printStackTrace();
		    System.out.println("false");
		    return null;
		}
		    // 正式完工
		    transactionManager.commit(status);
		    System.out.println("ture");
		    return rowcount;
	  }
	
}
