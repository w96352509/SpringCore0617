package com.spring.core.session06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.entity.Emp;
import com.spring.core.session06.template.EmpDao;

public class TemplateTest1 {

	@Test
	public void test() {
		// XML 配置
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		
		// JAVA 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
		EmpDao empDao = ctx.getBean("empDao",EmpDao.class);
		// 多筆配置
		List<Object[]> rows = new ArrayList<>();
		rows.add(new Object[]{"test3",18});
		rows.add(new Object[] {"test4",19});
		
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("test5" , 19));
		emps.add(new Emp("test6" , 20));
		
		
		
		//List<Map<String, Object>> emps = empDao.queryAll();
	    //String ename = emps.stream().filter(e->e.get("eid").toString().equals("2")).findFirst().get().get("ename").toString();
        
		//單筆新增
	    //int rowcount = empDao.add2("test2", 18);
        
	    //多筆新增
	    // int[] rowcount = empDao.multiAdd(rows);
		// System.out.println(Arrays.toString(rowcount));
		//int[] rowcount = empDao.multiAdd2(emps);
		// 修改
		//int rowcount = empDao.updateById(18,"test18", 18);
		//int rowcount = empDao.deleteById(18);
		//System.out.println(Arrays.toString(rowcount));
	    //System.out.println(ename);t
	    empDao.queryEmpAndJob().stream().forEach(System.out::println);
	    //System.out.println(empDao.queryAllEmp2());
	    
	    
	}
	
}
