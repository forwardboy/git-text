package com.bobo.model;

import java.io.Serializable;

public class User implements Serializable {
	private int uid;
	private String username;
	private String password;
	private String jianjie;
	private int age;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}