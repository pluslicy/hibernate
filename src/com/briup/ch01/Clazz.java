package com.briup.ch01;

import java.util.HashSet;
import java.util.Set;

//班级信息
public class Clazz {
	private Long id;
	private String name;
	private String messge;
	//在班级类中维护学生对象集合  clazz 1-n stus
	private Set<Student> stus = new HashSet<Student>();
	public Clazz() {
	}
	public Clazz(String name, String messge) {
		super();
		this.name = name;
		this.messge = messge;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessge() {
		return messge;
	}
	public void setMessge(String messge) {
		this.messge = messge;
	}
	public Set<Student> getStus() {
		return stus;
	}
	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}
}
