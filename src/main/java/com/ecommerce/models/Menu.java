package com.ecommerce.models;


import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ecommerce.dao.BrandDao;
import com.ecommerce.dao.ProductDao;

public class Menu {
	
	public void displayMenu() {
		
		boolean displayValue = true;
		ProductDao pdao = new ProductDao();
		BrandDao bdao = new BrandDao();
		
		Logger log = LogManager.getLogger(Menu.class);
		
		
		System.out.println("******************************************************");
		System.out.println("   Welcome to E-Commerce Products Management System! ");
		System.out.println("******************************************************");
		
		Scanner scan = new Scanner(System.in);
		
		while(displayValue) {
			
			System.out.println("--------------------------");
			System.out.println(" Please Choose An Option: ");
			System.out.println("--------------------------");
			
			System.out.println("brands -> Show all brands");
			System.out.println("products -> Show all products");
			System.out.println("productByName -> Show product by inputting its name");
			System.out.println("productsByBrand -> Show products by inputting brand");
			System.out.println("brandByName -> Show brand by inputting its name");
			System.out.println("brandsByFirstLetter-> Show brands by inputting first letter");
			System.out.println("addBrand -> Add a brand");
			System.out.println("addProduct -> Add a product");
			System.out.println("updateProductPrice -> Change the product price");
			System.out.println("deleteProduct -> Delete a product");
			System.out.println("deleteBrand -> Delete a brand");
			System.out.println("deleteBrandsByFirstLetter -> Delete brands by the first letter");
			System.out.println("exit -> Exit system!");
			
			String input = scan.nextLine();
			
			switch(input) {
			
            case "brands": { 
			 	
				List<Brand> brands = bdao.getBrands();
				
				for(Brand b : brands) {
					System.out.println(b);
				}
				
				log.info("All of the brands were retrieved.");
				
				break;
				
			}
			
			case "products": { 
				
				List<Product> products = pdao.getProducts();
				
				for(Product p : products) {
					System.out.println(p);
				}
				
				log.info("All of the products were retrieved.");
				
				break;
				
			}
			
			
			case "productByName":{
				
				System.out.println("Enter product name to search: ");
				
				String product_name = scan.nextLine();
				
				List<Product> products = pdao.getProductByName(product_name);
				
				if(products.size() == 0) {
					System.out.println("Product " + product_name + " was not found in the system.");
					break;
				}
				
				for(Product p : products) {
					System.out.println(p);
				}
				
				log.info("Product " + product_name + " was retrieved.");
				
				break;
				
			}
			
			
			case "productsByBrand":{
				
				System.out.println("Enter brand name to search: ");
				
				String brand_name = scan.nextLine();
				
				List<Product> products = pdao.getProductsByBrand(brand_name.toLowerCase());
				
				if(products.size() == 0) {
					System.out.println("Brand " + brand_name + " was not found in the system, please search for other brand's products.");
					break;
				}
				
				for(Product p : products) {
					System.out.println(p);
				}
				
				log.info("Products of " + brand_name + " were retrieved.");
				
				break;
				
			}
			
			
			case "brandByName":{
				
				System.out.println("Enter brand name to search: ");
				String brand_name = scan.nextLine();
				
				List<Brand> brands = bdao.getBrandByName(brand_name);
				
				if(brands.size() == 0) {
					System.out.println("Brand " + brand_name + " was not found in the system.");
					break;
				}
				
				
				for(Brand b : brands) {
					System.out.println(b);
				}
				
				log.info("Brand " + brand_name + " was retrieved.");
				
				break;
				
			}
			
			
			
			case "brandsByFirstLetter":{
				
				System.out.println("Enter the first letter to search brands: ");
				String first_letter = scan.nextLine();
				
				List<Brand> brands = bdao.getBrandByFirstLetter(first_letter);
				
				if(brands.size() == 0) {
					System.out.println("Brands with first letter " + first_letter + " were not found in the system.");
					break;
				}
				
				
				for(Brand b : brands) {
					System.out.println(b);
				}
				
				log.info("Brands with first letter " + first_letter + " were retrieved.");
				
				break;
				
			}
			
			
			
			
            case "addBrand":{
				
				System.out.println("Enter brand name:");
				String brand_name = scan.nextLine();
				
				System.out.println("Enter first letter of the brand:");
				String first_letter = scan.nextLine();
			
				Brand b = new Brand(brand_name,first_letter);
				
				bdao.addBrand(b);
				
				log.info("Brand " + brand_name + " was added to database.");
			
				break;
			}
			
			
			case "addProduct":{
				
				System.out.println("Enter product name:");
				String product_name = scan.nextLine();
				
				System.out.println("Enter product detail:");
				String detail = scan.nextLine();
				
				System.out.println("Enter product price:");
				double price = scan.nextDouble();
				
				
				List<Brand> brands = bdao.getBrands();
				
				System.out.println("The brands in the E-Commerce product management system include: ");
				for(Brand b : brands) {
					System.out.println("[brand_name: " + b.getBrand_name() + ", " + "brand_id: " + b.getBrand_id() + "]");
				}
				System.out.println("If the brand was not found in the system, please enter 0 and then add brand before attempting to add the brand's product.");
			
				System.out.println("Enter the brand_id of the product:");
				int brand_id = scan.nextInt();
				
				if(brand_id == 0) {
					break;
				}
				
				Product p = new Product(product_name, price, detail, brand_id);
				
				pdao.addProduct(p);
				
				log.info("Product " + product_name + " was added to database.");
			
				break;
			}
			
			
			case "updateProductPrice":{
				
				System.out.println("Enter product name to change:");
				String product_name = scan.nextLine();
				
				List<Product> products = pdao.getProductByName(product_name);
				
				if(products.size() == 0) {
					System.out.println("Product " + product_name + " was not found in the system.");
					break;
				}
				
				System.out.println("Enter product price:");
				double price = scan.nextDouble();
				
				
				pdao.updateProductPrice(product_name, price);
				
				
				log.info("Product " + product_name + " price was changed.");
				
				break;
				
			}
			
			case "deleteProduct":{
				
				System.out.println("Enter product name to delete:");
				String product_name = scan.nextLine();
				
				List<Product> products = pdao.getProductByName(product_name);
				
				if(products.size() == 0) {
					System.out.println("Product " + product_name + " was not found in the system.");
					break;
				}
				
				pdao.deleteProduct(product_name);
				
				log.warn("Product " + product_name + " was deleted.");
				
				break;
				
			}

            case "deleteBrand":{
				
				System.out.println("Enter brand name to delete:");
				String brand_name = scan.nextLine();
				
				List<Brand> brands = bdao.getBrandByName(brand_name);
				
				if(brands.size() == 0) {
					System.out.println("Brand " + brand_name + " was not found in the system.");
					break;
				}
				
				bdao.deleteBrand(brand_name);
				
				log.warn("Brand " + brand_name + " was deleted.");
				
				break;
				
			}
            
            case "deleteBrandsByFirstLetter":{
				
				System.out.println("Enter the first letter of brands to delete:");
				String first_letter = scan.nextLine();
				
				List<Brand> brands = bdao.getBrandByFirstLetter(first_letter);
				
				if(brands.size() == 0) {
					System.out.println("Brands with first letter " + first_letter + " were not found in the system.");
					break;
				}
				
				bdao.deleteBrandsByFirstLetter(first_letter);
				
				log.warn("Brands with first letter " + first_letter + " were deleted.");
				
				break;
				
			}
			
			case "exit":{
				displayValue = false;
				System.out.println("See you again!");
				break;
				
			}
			
			default:{
				System.out.println("Please try again!");
				break;
			}
			
			}
			
		}
		
		System.out.println("Thank you for using the E-Commerce product management system!");
		scan.close();
		
		
	}
}
