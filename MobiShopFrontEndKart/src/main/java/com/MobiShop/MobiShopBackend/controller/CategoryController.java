package com.MobiShop.MobiShopBackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MobiShop.MobiShopBackend.dao.CategoryDao;
import com.MobiShop.MobiShopBackend.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDAO;
	
	@RequestMapping(value="CategoryAddition", method=RequestMethod.GET)
	public String addCategory(@RequestParam("catid") int catid,@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc)
	{
		System.out.println("CategoryID:"+catid);
		System.out.println("CategoryName:"+catname);
		System.out.println("Category Desc:"+catdesc);
		
		Category category=new Category();
		category.setCatid(catid);
		category.setCatname(catname);
		category.setCatdesc(catdesc);
		
		categoryDAO.insertCategory(category);
		
		return "Category";
	}
	
	@RequestMapping("Category")
	public String showCategoryPage()
	{
		return "Category";
	}
}
