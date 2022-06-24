package com.spring.core.session03;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.Student;
import com.spring.core.session03.beans.Teacher;

public class TestTeacher {

	@Test
	public void Test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Clazz clazz = ctx.getBean("clazz1",Clazz.class);
		Teacher teacher1 = ctx.getBean("teacher1" , Teacher.class);
		Teacher teacher2 = ctx.getBean("teacher2" , Teacher.class);
		System.out.println(teacher1);
		System.out.println(teacher2);
		// 請問 teacher1 讀學生每個人平均是幾分
		teacher1.getStudents()
		        .stream()
		        .map(Student::getClazzs)
		        .forEach(s->{
		        	int sum    = s.stream().mapToInt(c->c.getCredit()).sum(); 
		        	//System.out.println("總和" + sum);
		            double avg = s.stream().mapToInt(c->c.getCredit()).average().getAsDouble();
		            //System.out.println("平均" + avg);
		            IntSummaryStatistics stat =  s.stream().mapToInt(c -> c.getCredit()).summaryStatistics();
		            //System.out.println("平均" + stat.getAverage());
		        });
	                teacher1.getStudents()
	                        .stream()
	                        .mapToDouble(t->t.getClazzs()
	                        		         .stream()
	                    		             .mapToInt(Clazz::getCredit)
	                    		             .average().getAsDouble())
	                                         .forEach(System.out::println);
	                                       
	}
	
}
