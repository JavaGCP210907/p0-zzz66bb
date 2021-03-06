package com.ecommerce.models;



public class Product {
	
	private int product_id;
	private String product_name;
	private double price;
	private String detail;
	private int brand_id;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_id, String product_name, double price, String detail, int brand_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.detail = detail;
		this.brand_id = brand_id;
	}

	public Product(String product_name, double price, String detail, int brand_id) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.detail = detail;
		this.brand_id = brand_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	@Override
	public String toString() {
		
		return "[product_id: " + product_id + "," + "\n" + "product_name: " + product_name + "," + "\n" + " price: " + price + "," + "\n" + " detail: "
				+ detail + "," + "\n" + " brand_id: " + brand_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brand_id;
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + product_id;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand_id != other.brand_id)
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (product_id != other.product_id)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		return true;
	}
	
	
}