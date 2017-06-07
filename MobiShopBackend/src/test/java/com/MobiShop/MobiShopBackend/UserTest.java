package com.MobiShop.MobiShopBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MobiShop.MobiShopBackend.dao.UserDao;
import com.MobiShop.MobiShopBackend.model.User;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.MobiShop.MobiShopBackend");
		context.refresh();
				
		User user=(User)context.getBean("user");
				 
		UserDao userdao=(UserDao)context.getBean("userDAO");
				 
		/*	user.setUserid(1);
			user.setUsername("John");
			user.setPassword("12345");
			user.setMobile(99887501);
			user.setAddress("Punjab");
			user.setEmail("john@gmail.com");
			
			userdao.insertUser(user);
			*/
			}

	}
