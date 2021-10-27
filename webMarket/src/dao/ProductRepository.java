package dao;

import dto.Product;


import java.util.ArrayList;


public class ProductRepository {
	
	private ArrayList<Product> listOfProducts = new ArrayList<Product>() ;

	public ProductRepository() {
		Product phone = new Product("p1234","iPhone 13 pro",1500000);
		phone.setDescription("5.5 -inch,1500 * 750 Retina FHD display,10-megapixel Camera, ");
		phone.setCategory("Smart phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInstock(100);
		
		Product notebook = new Product("p1235","LG gram",2000000);
		notebook.setDescription("15 -inch,1920 * 1080 Retina FHD display,15-megapixel Camera, ");
		notebook.setCategory("Notebook");
		notebook.setManufacturer("LG");
		notebook.setUnitsInstock(100);
		
		Product tablet = new Product("p1236","Galaxy tab s7",900000);
		tablet.setDescription("11 -inch,1080 * 1020 Retina FHD display,15-megapixel Camera, ");
		tablet.setCategory("tablet");
		tablet.setManufacturer("SAMSUNG");
		tablet.setUnitsInstock(100);
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}
	
	public ArrayList<Product> getAllProducts(){
		return listOfProducts;
	}
	
}
