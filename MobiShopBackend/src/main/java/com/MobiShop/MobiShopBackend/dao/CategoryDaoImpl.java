package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MobiShop.MobiShopBackend.model.Category;

@Repository("categoryDAO")
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertCategory(Category category)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}
	
	@Transactional 
	public void deleteCategory(int catid)
	{
		Session session=sessionFactory.getCurrentSession();
		Category category=(Category)session.get(Category.class,catid);
		session.delete(category);
	}
	
	public List<Category> retrieve()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Category> list=session.createQuery("from Category").list();
		session.close();
		return list;
	}
}