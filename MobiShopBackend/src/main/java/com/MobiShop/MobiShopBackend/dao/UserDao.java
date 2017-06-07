package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import com.MobiShop.MobiShopBackend.model.User;

public interface UserDao {
	public void insertUser(User user);
	
	public void deleteUser(int userid);
	
	public List<User> retrieve();
	
	public User get (int id);
	
	public User getByName(String name);
	
}
