package com.margo.project.reflect.filed;

public class YbFiledVO extends YbFieldFatherVO{
	public String name;
	private int age;
	char cup;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getCup() {
		return cup;
	}
	public void setCup(char cup) {
		this.cup = cup;
	}
}
