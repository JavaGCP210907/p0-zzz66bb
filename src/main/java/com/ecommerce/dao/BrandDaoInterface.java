package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.models.Brand;
import com.ecommerce.models.Product;

public interface BrandDaoInterface {
	
	public List<Brand> getBrands();
	
	public void addBrand(Brand b);
	
	public List<Brand> getBrandByName(String brand_name);
	
	public void deleteBrand(String brand_name);
	
	public List<Brand> getBrandByFirstLetter(String first_letter);
	
	public void deleteBrandsByFirstLetter(String first_letter);

}