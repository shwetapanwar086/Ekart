package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MobiShop.MobiShopBackend.model.User;

@Repository("userDAO")
public class UserDaoImpl implements UserDao{
public UserDaoImpl() {
	
}
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public User get(int id) {

	
		String hql = "from User where id='" + id + "'";
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		if (listUser != null && !listUser.isEmpty()) {			
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public User getByName(String name) {

		String hql = "from User where name='" + name + "'";
		
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
		
			return listUser.get(0);
		}

		return null;
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
		User user=(User)session.get(User.class, userid);
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