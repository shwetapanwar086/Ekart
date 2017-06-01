package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import com.MobiShop.MobiShopBackend.model.Category;

public interface CategoryDao {
	public void insertCategory(Category category);
	public void deleteCategory(int catid);
	public List<Category> retrieve();
}
