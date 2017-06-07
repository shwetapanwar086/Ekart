package com.MobiShop.MobiShopBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MobiShop.MobiShopBackend.dao.ProductDao;
import com.MobiShop.MobiShopBackend.model.Product;

public class ProductTest {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.MobiShop.MobiShopBackend");
		context.refresh();
		
		Product product = (Product)context.getBean("product");
		
		ProductDao productdao = (ProductDao)context.getBean("productDAO");
		
		product.setProdid(1001);
		product.setProdname("iphone6s");
		product.setCatid(101);
		product.setSuppid(10001);
		product.setPrice(20000);
		product.setStock(10);
		product.setDesc("This is a 4G Mobile");
		
		product.setProdid(1002);
		product.setProdname("iphone7");
		product.setCatid(102);
		product.setSuppid(10002);
		product.setPrice(30000);
		product.setStock(10);
		product.setDesc("This is a 4G Mobile with advanced features"); 
		
	/*  product.setProdid(1003);
		product.setProdname("iphone7s");
		product.setCatid(103);
		product.setSuppid(10003);
		product.setPrice(40000);
		product.setStock(20);
		product.setDesc("This is a 4G Mobile available in 32GB and 64GB memmory");
		*/
		productdao.insertProduct(product);
		System.out.println("Product Inserted");
		
		/*productdao.deleteProduct(1002);
		
		System.out.println("Deleted");
		
		
		List<Product> list=productdao.retrieve();
		
		for(Product p:list)
		{
			System.out.println(p.getProdid()+":::");
			System.out.println(p.getProdname()+":::");
			System.out.println(p.getCatid()+":::");
			System.out.println(p.getSuppid()+":::");
			System.out.println(p.getStock()+":::");
			System.out.println(p.getDesc()+":::");
			System.out.println(p.getPrice()+":::");
		}

		Product product1=productdao.getProduct(1001);
		
		product1.setDesc("This is Simple Mobile with Camera Feature");
		product1.setPrice(14000);
		product1.setStock(20);
		
		//productdao.updateProduct(product1);
		*/
		//System.out.println("Product is Updated");
	}
}