package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MobiShop.MobiShopBackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDaoImpl implements SupplierDao{
public SupplierDaoImpl() {
	
}
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public Supplier get(int id) {

	
		String hql = "from Supplier where id='" + id + "'";
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) query.list();
		if (listSupplier != null && !listSupplier.isEmpty()) {			
			return listSupplier.get(0);
		}
		return null;
	}

	@Transactional
	public Supplier getByName(String name) {

		String hql = "from Supplier where name='" + name + "'";
		
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) query.list();

		if (listSupplier != null && !listSupplier.isEmpty()) {
		
			return listSupplier.get(0);
		}

		return null;
	}
	@Transactional
	public void insertSupplier(Supplier supplier)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}
	
	@Transactional 
	public void deleteSupplier(int suppid)
	{
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,suppid);
		session.delete(supplier);
	}
	
	public List<Supplier> retrieve()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Supplier> list=session.createQuery("from Supplier").list();
		session.close();
		return list;
	}
}