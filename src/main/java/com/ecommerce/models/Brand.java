package com.ecommerce.models;

public class Brand {
	
	private int brand_id;
	private String brand_name;
	private String first_letter;
	
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(int brand_id, String brand_name, String first_letter) {
		super();
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.first_letter = first_letter;
	}
	
	

	public Brand(String brand_name, String first_letter) {
		super();
		this.brand_name = brand_name;
		this.first_letter = first_letter;
	}

	@Override
	public String toString() {
		return "[brand_id: " + brand_id + "," + "\n" + " brand_name: " + brand_name + "," + "\n" + " first_letter: " + first_letter + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brand_id;
		result = prime * result + ((brand_name == null) ? 0 : brand_name.hashCode());
		result = prime * result + ((first_letter == null) ? 0 : first_letter.hashCode());
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
		Brand other = (Brand) obj;
		if (brand_id != other.brand_id)
			return false;
		if (brand_name == null) {
			if (other.brand_name != null)
				return false;
		} else if (!brand_name.equals(other.brand_name))
			return false;
		if (first_letter == null) {
			if (other.first_letter != null)
				return false;
		} else if (!first_letter.equals(other.first_letter))
			return false;
		return true;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getFirst_letter() {
		return first_letter;
	}

	public void setFirst_letter(String first_letter) {
		this.first_letter = first_letter;
	}
	
	
}
