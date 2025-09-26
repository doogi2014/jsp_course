package cn.doogi.model;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -4110516602874528822L;
	
	private String name;
	private int count;
	private int price;
	
	public Order() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
