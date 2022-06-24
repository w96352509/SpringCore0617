package com.spring.core.session03.beans;

import java.util.Set;

public class Student {

	private Integer id;   // 學生學號
	
	private String  name; // 學生姓名
	
	private Set<Clazz> clazzs; // 學生選課(科目不重複)

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

	public Set<Clazz> getClazzs() {
		return clazzs;
	}

	public void setClazzs(Set<Clazz> clazzs) {
		this.clazzs = clazzs;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clazzs=" + clazzs + "]";
	}
	
	
	
}
