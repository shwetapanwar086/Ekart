package com.MobiShop.MobiShopBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MobiShop.MobiShopBackend.dao.CategoryDao;
import com.MobiShop.MobiShopBackend.model.Category;

public class CategoryTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.MobiShop.MobiShopBackend");
		context.refresh();
		
		 Category category=(Category)context.getBean("category");
		 
		 CategoryDao categorydao=(CategoryDao)context.getBean("categoryDAO");
		 categorydao.delete("cat01");
		 
		 
	
	}

}
