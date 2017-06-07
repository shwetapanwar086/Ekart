package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import com.MobiShop.MobiShopBackend.model.UsersDetail;



public interface UsersDetailDao {

	   public void addUser (UsersDetail usersDetail);

	   public UsersDetail getUserById (int userId);

	   public List<UsersDetail> getAllUsers();

	    UsersDetail getUserByUsername (String username);
	  
	    public boolean isValidUser(String name);
	}