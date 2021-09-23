package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.models.Product;

public interface ProductDaoInterface {
	
	public List<Product> getProducts();
	
	public List<Product> getProductsByBrand(String brand);
	
	public List<Product> getProductByName(String product_name);
	
	public void addProduct(Product p);
	
	public void updateProductPrice(String product_name, double price);
	
	public void deleteProduct(String product_name);

}
