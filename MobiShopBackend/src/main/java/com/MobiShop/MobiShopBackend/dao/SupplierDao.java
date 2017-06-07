package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import com.MobiShop.MobiShopBackend.model.Supplier;

public interface SupplierDao {
	public void insertSupplier(Supplier supplier);
	
	public void deleteSupplier(int suppid);
	
	public List<Supplier> retrieve();
	
	public Supplier get(int id);
	
	public Supplier getByName(String name);
	
}
