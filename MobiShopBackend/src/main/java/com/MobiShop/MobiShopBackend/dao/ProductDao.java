package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import com.MobiShop.MobiShopBackend.model.Product;

public interface ProductDao {

	public boolean save(Product product);

	public boolean update(Product product);

	public boolean saveOrUpdate(Product product);

	public boolean delete(String id);

	public Product get(String id);
	
	public Product getByName(String name);

	public List<Product> list();
}
