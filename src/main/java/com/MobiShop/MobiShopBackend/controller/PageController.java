package com.MobiShop.MobiShopBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MobiShop.MobiShopBackend.dao.CategoryDao;
import com.MobiShop.MobiShopBackend.dao.ProductDao;
import com.MobiShop.MobiShopBackend.model.Product;



@Controller
public class PageController {
	
	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private ProductDao productDAO;
	
	
	
	@RequestMapping("/")
	public ModelAndView getPage( @ModelAttribute("selectedProduct") final Product selectedProduct) {
	
		ModelAndView model=new ModelAndView("/index");
		
		model.addObject("categoryList", categoryDAO.list());
		model.addObject("productList", productDAO.list());
		
		
		System.out.println("inside / mapping");

		if(selectedProduct!=null){
			model.addObject("selectedProduct",selectedProduct);
		}
		else
			System.out.println("The object is null");
		
		return model;
		
	}

	@RequestMapping("aboutus")
	public String aboutUs()
	{
		return "aboutus";
	}
	@RequestMapping("Register")
	public String showRegister()
	{
		return "Register";
	}
}

