package com.MobiShop.MobiShopBackend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MobiShop.MobiShopBackend.model.Product;

@Repository
public class ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	private Serializable prodid;
	
	public ProductDAO(SessionFactory sessionFactory)
	{
		System.out.println("ProductDAO object Created");
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertProduct(com.MobiShop.MobiShopBackend.model.Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	@Transactional
	public void deleteProduct()
	{
		Session session=sessionFactory.getCurrentSession();
		Product product =(Product)session.get(Product.class,prodid);
		session.delete(product);
	}
	
	public List<Product> retrieveProduct()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> list=(List<Product>)query.list();
		session.close();
		return list;
	}
	public Product getProduct(int prodid)
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,prodid);
		session.close();
		return product;
	}
	
	@Transactional
	public void updateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
	}
}

