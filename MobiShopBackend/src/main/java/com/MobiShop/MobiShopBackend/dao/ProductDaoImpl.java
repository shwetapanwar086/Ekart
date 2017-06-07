package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MobiShop.MobiShopBackend.model.Product;

@Repository("productDAO")
public class ProductDaoImpl implements ProductDao{
public ProductDaoImpl() {
	
}
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public Product get(int id) {

	
		String hql = "from Product where id='" + id + "'";
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		if (listProduct != null && !listProduct.isEmpty()) {			
			return listProduct.get(0);
		}
		return null;
	}

	@Transactional
	public Product getByName(String name) {

		String hql = "from Product where name='" + name + "'";
		
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
		
			return listProduct.get(0);
		}

		return null;
	}
	@Transactional
	public void insertProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	
	@Transactional 
	public void deleteProduct(int prodid)
	{
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class,prodid);
		session.delete(prodid);
	}
	
	public List<Product> retrieve()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Product> list=session.createQuery("from Product").list();
		session.close();
		return list;
	}
	public Product getProduct(int prodid) {
		String hql = "from Product where id='" + prodid + "'";
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		if (listProduct != null && !listProduct.isEmpty()) {			
			return listProduct.get(0);
		}
		return null;
	}
	
	
	/*public void updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, product);
		session.update(product);
		
	}*/

}