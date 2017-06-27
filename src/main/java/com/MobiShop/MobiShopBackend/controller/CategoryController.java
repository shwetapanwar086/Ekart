package com.MobiShop.MobiShopBackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MobiShop.MobiShopBackend.Util.Util;
import com.MobiShop.MobiShopBackend.dao.CategoryDao;
import com.MobiShop.MobiShopBackend.model.Category;


@Controller
public class CategoryController {
	@Autowired
	private CategoryDao categoryDAO;
	

	@Autowired(required = true)
	@Qualifier(value = "categoryDAO")
	public void setCategoryDAO(CategoryDao categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(Model model) {
		System.out.println("Hello.. I'm inside /categories list");
		//TO CARRY THE DATA TO NEXT PAGE
		model.addAttribute("category", new Category());
		model.addAttribute("isAdminClickedCategories", "true");
		model.addAttribute("categoryList",categoryDAO.list());
		return "Admin";
	}

	// For add and update category both
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {

		System.out.println("Hello.. I'm inside /categories add");
		
		String newID=Util.removeComma(category.getId());
		category.setId(newID);
		categoryDAO.saveOrUpdate(category);
		return "redirect:/categories";
	}

	@RequestMapping("/category/remove/{id}")
	public String removeCategory(@PathVariable("id") String id, ModelMap model) throws Exception {

		System.out.println("Hello.. I'm inside /categories remove");
		
		try {
			categoryDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/categories";
	}

	@RequestMapping("/category/edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {
		System.out.println("Hello.. I'm inside /categories edit");
		model.addAttribute("category", this.categoryDAO.get(id));
		model.addAttribute("isAdminClickedEditCategories", "true");
		//model.addAttribute("listCategories", this.categoryDAO.list());
		return "Admin";
	}
}
