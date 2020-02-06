package com.unmannedstore.shoppingcart;

public class goods {
	protected int id;
	protected String name;
	protected int price;
	protected int quantity;
	protected String information;
	protected int sales;
	protected String img;
	
	public goods() {
		super();
	}

	public goods(String name, int price, int quantity, String information, int sales, String img) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.information = information;
		this.sales = sales;
		this.img = img;
	}

	public goods(int id, String name, int price, int quantity, String information, int sales, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.information = information;
		this.sales = sales;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	

}
	
