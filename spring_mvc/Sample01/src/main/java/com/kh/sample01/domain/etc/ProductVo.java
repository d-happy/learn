package com.kh.sample01.domain.etc;

public class ProductVo {
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVo [name=" + name + ", price=" + price + "]";
	}
	
	
}
