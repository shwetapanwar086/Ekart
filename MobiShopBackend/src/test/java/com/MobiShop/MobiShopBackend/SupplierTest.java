package com.MobiShop.MobiShopBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MobiShop.MobiShopBackend.dao.SupplierDao;
import com.MobiShop.MobiShopBackend.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.MobiShop.MobiShopBackend");
		context.refresh();
		
		Supplier supplier = (Supplier) context.getBean("supplier");
		
		SupplierDao supplierdao = (SupplierDao)context.getBean("supplierDAO");
		
		supplier.setSuppid(10001);
		supplier.setSuppname("MacRead");
		supplier.setAddress("New Delhi");
		
		supplierdao.insertSupplier(supplier);
	}

}
