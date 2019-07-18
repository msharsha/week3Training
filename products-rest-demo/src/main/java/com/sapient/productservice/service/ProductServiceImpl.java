package com.sapient.productservice.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sapient.productservice.dao.ProductDao;
import com.sapient.productservice.model.Product;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired(required = false) 
	@Qualifier(value = "hibernateImpl")
	private ProductDao productDao;
	
	public ProductServiceImpl(@Qualifier(value = "hibernateImpl")ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Inside the save product method of Product service class ....");
		return productDao.saveProduct(product);
	}

	@Override
	@Transactional
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return productDao.listAll();
	}

	@Override
	@Transactional
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(id);
	}

	@Override
	@Transactional
	public void updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		productDao.updateProduct(id, product);
	}
}
