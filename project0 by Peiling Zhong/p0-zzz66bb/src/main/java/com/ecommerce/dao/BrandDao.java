package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.models.Brand;
import com.ecommerce.models.Product;
import com.ecommerce.utils.DataConnectionUtil;

public class BrandDao implements BrandDaoInterface{

	@Override
	public List<Brand> getBrands() {
		
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			ResultSet result = null;
			
			String sql = "select * from brand";
			
			Statement s = conn.createStatement();
			
			result = s.executeQuery(sql);
			
			List<Brand> brandsList = new ArrayList<>();
			
			while(result.next()) {
				
				Brand b = new Brand(
						result.getInt("brand_id"), 
						result.getString("brand_name"), 
						result.getString("first_letter")
						);
				brandsList.add(b);
			}
			
			return brandsList;
			
			
			
		} catch(SQLException e) {
			System.out.println("Database went wrong.");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	

	@Override
	public List<Brand> getBrandByName(String brand_name) {
		
			try(Connection conn = DataConnectionUtil.getConnection()){
			
			ResultSet result = null;
			
			String sql = "select * from brand where brand_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, brand_name);
			
			result = ps.executeQuery();
			
			List<Brand> brandsList = new ArrayList<>();
			
			while(result.next()) {
				
				Brand b = new Brand(
						result.getInt("brand_id"), 
						result.getString("brand_name"), 
						result.getString("first_letter")
						);
				brandsList.add(b);
			}
			
			return brandsList;
			
			
		} catch(SQLException e) {
			System.out.println("Getting products failed. Database went wrong.");
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	

	@Override
	public List<Brand> getBrandByFirstLetter(String first_letter) {
		
			try(Connection conn = DataConnectionUtil.getConnection()){
			
			ResultSet result = null;
			
			String sql = "select * from brand where first_letter = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, first_letter);
			
			result = ps.executeQuery();
			
			List<Brand> brandsList = new ArrayList<>();
			
			while(result.next()) {
				
				Brand b = new Brand(
						result.getInt("brand_id"), 
						result.getString("brand_name"), 
						result.getString("first_letter")
						);
				brandsList.add(b);
			}
			
			return brandsList;
			
			
		} catch(SQLException e) {
			System.out.println("Getting products failed. Database went wrong.");
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public void addBrand(Brand b) {
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			String sql = "insert into brand (brand_name, first_letter)" + " values (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, b.getBrand_name());
			ps.setString(2, b.getFirst_letter());
			
			ps.executeUpdate();
			
			System.out.println("Brand " + b.getBrand_name() + " added!");
				
		} catch(SQLException e) {
			System.out.println("Adding brand failed. Database went wrong.");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBrand(String brand_name) {
        try(Connection conn = DataConnectionUtil.getConnection()){
			
			String sql = "delete from brand where brand_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, brand_name);
			ps.executeUpdate();
			
			System.out.println(brand_name + " has been deleted!");
		} catch(SQLException e) {
			System.out.println(brand_name + " has not been deleted. Database went wrong.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBrandsByFirstLetter(String first_letter) {
		try(Connection conn = DataConnectionUtil.getConnection()){
			
			String sql = "delete from brand where first_letter = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, first_letter);
			ps.executeUpdate();
			
			System.out.println("brands with the first letter " + first_letter + " has been deleted!");
		} catch(SQLException e) {
			System.out.println("brands with the first letter " + first_letter + " has not been deleted. Database went wrong.");
			e.printStackTrace();
		}
	
	}
	
	
	
	
}

		