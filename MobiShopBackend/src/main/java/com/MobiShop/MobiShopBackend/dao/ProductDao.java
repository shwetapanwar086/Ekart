package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import com.MobiShop.MobiShopBackend.model.Product;

public interface ProductDao {
	public void insertProduct(Product product);
	
	public void deleteProduct(int i);
	
	public List<Product> retrieve();
	
	public Product getProduct (int i);
	
	public Product getByName(String name);

	//public void updateProduct(Product product1);	
}
