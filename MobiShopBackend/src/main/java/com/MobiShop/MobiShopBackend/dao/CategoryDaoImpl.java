package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MobiShop.MobiShopBackend.model.Category;

@Repository("categoryDAO")
public class CategoryDaoImpl implements CategoryDao{
public CategoryDaoImpl() {
	
}
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public Category get(String id) {

	
		String hql = "from Category where id='" + id + "'";
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		if (listCategory != null && !listCategory.isEmpty()) {			
			return listCategory.get(0);
		}
		return null;
	}

	@Transactional
	public Category getByName(String name) {

		String hql = "from Category where name='" + name + "'";
		
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();

		if (listCategory != null && !listCategory.isEmpty()) {
		
			return listCategory.get(0);
		}

		return null;
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