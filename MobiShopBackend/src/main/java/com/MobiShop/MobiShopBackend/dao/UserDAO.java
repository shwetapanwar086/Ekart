package com.MobiShop.MobiShopBackend.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MobiShop.MobiShopBackend.model.User;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAO (SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUser(User user)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
	
	@Transactional
	public void deleteUser(int userid)
	{
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,userid);
		session.delete(user);
	}
	
	public List<User> retrieve()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> list=session.createQuery("from User").list();
		session.close();
		return list;
	}
}
