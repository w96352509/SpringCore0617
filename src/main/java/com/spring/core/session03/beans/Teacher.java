package com.spring.core.session03.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Teacher {

	private Integer id;            // 講師編號
	 
	private String name;           // 講師名稱
	
	private Set<Student> students; // 學生列表
	
	private List<String> subjects; // 授課科目
	
	private Map<String, Integer> salary; // 薪資組合

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public Map<String, Integer> getSalary() {
		return salary;
	}

	public void setSalary(Map<String, Integer> salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", students=" + students + ", subjects=" + subjects
				+ ", salary=" + salary + "]";
	}
 	
	
	
}
