package com.dxf.model;

public class Student {
	private int id;
	private int stu_number;
	private String name;
	private String sex;
	private String birthdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStu_number() {
		return stu_number;
	}
	public void setStu_number(int stu_number) {
		this.stu_number = stu_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stu_number=" + stu_number + ", name="
				+ name + ", sex=" + sex + ", birthdate=" + birthdate + "]";
	}
	
	
	

}
