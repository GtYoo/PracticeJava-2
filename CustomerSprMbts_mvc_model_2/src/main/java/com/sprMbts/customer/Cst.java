package com.sprMbts.customer;

public class Cst {
	
	private int code;
	private String name;
	private String email;
	private String tel;
	private double weight;
	
	public Cst() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cst [code=" + code + ", name=" + name + ", email=" + email + ", tel=" + tel + ", weight=" + weight
				+ "]";
	}
	
	
}
