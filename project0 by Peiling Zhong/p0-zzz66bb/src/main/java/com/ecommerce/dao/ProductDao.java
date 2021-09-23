package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.models.Product;
import com.ecommerce.utils.DataConnectionUtil;

public class ProductDao implements ProductDaoInterface{

	@Override
	public List<Product> getProducts() {
		
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			ResultSet result = null;
			
			String sql = "select * from product";
			
			Statement s = conn.createStatement();
			
			result = s.executeQuery(sql);
			
			List<Product> productsList = new ArrayList<>();
			
			while(result.next()) {
				
				Product p = new Product(
						result.getInt("product_id"), 
						result.getString("product_name"), 
						result.getDouble("price"),
						result.getString("detail"),
						result.getInt("brand_id")
						);
				productsList.add(p);
			}
			
			return productsList;
			
			
			
		} catch(SQLException e) {
			System.out.println("Getting products failed. Database went wrong.");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

	@Override
	public List<Product> getProductByName(String product_name) {
		
			try(Connection conn = DataConnectionUtil.getConnection()){
			
			ResultSet result = null;
			
			String sql = "select * from product where product_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, product_name);
			
			result = ps.executeQuery();
			
			List<Product> productsList = new ArrayList<>();
			
			while(result.next()) {
				
				Product p = new Product(
						result.getInt("product_id"), 
						result.getString("product_name"), 
						result.getDouble("price"),
						result.getString("detail"),
						result.getInt("brand_id")
						);
				
				productsList.add(p);
			}
			
			return productsList;
			
			
		} catch(SQLException e) {
			System.out.println("Getting products failed. Database went wrong.");
			e.printStackTrace();
		}
		
		return null;

	}




	@Override
	public List<Product> getProductsByBrand(String brand) {
		
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			ResultSet result = null;
			
			String sql = "select * from product inner join brand" + " on product.brand_id = brand.brand_id where brand.brand_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, brand);
			
			result = ps.executeQuery();
			
			List<Product> productsList = new ArrayList<>();
			
			while(result.next()) {
				
				Product p = new Product(
						result.getInt("product_id"), 
						result.getString("product_name"), 
						result.getDouble("price"),
						result.getString("detail"),
						result.getInt("brand_id")
						);
				
				productsList.add(p);
			}
			
			return productsList;
				
		} catch(SQLException e) {
			System.out.println("Getting product failed. Database went wrong.");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addProduct(Product p) {
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			String sql = "insert into product (product_name, price, detail, brand_id)" + " values (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, p.getProduct_name());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getDetail());
			ps.setInt(4, p.getBrand_id());
			
			ps.executeUpdate();
			
			System.out.println("Product " + p.getProduct_name() + " added!");
				
		} catch(SQLException e) {
			System.out.println("Adding product failed. Database went wrong.");
			e.printStackTrace();
		}
	}

	@Override
	public void updateProductPrice(String product_name, double price) {
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			String sql = "update product set price = ? where product_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, price);
			ps.setString(2, product_name);
			
			ps.executeUpdate();
			
			System.out.println(product_name + " price has been changed!");
		} catch(SQLException e) {
			System.out.println(product_name + " price has not been changed. Database went wrong.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(String product_name) {
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			String sql = "delete from product where product_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, product_name);
			ps.executeUpdate();
			
			System.out.println(product_name + " has been deleted!");
		} catch(SQLException e) {
			System.out.println(product_name + " has not been deleted. Database went wrong.");
			e.printStackTrace();
		}
		
	}
	
}
