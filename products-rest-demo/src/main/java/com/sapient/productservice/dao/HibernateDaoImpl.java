package com.sapient.productservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;

@Repository(value="hibernateImpl")
public class HibernateDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product saveProduct(Product product) {
		 Session session = sessionFactory.getCurrentSession();
	     session.saveOrUpdate(product);
	     return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listAll() {
		  Session currentSession = sessionFactory.getCurrentSession();
	      return currentSession.createQuery("from Product ").list();
	}

	@Override
	public Product findById(int id) {
		 return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	     Product product = session.byId(Product.class).load(id);
	     session.delete(product);
	}

	@Override
	public void updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}

}
