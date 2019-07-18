package com.sapient.productservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;

@Repository(value="mySqlDAOImpl")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Product saveProduct(Product product) {
		System.out.println("Came inside the save method of ProductDAOImpl");
		jdbcTemplate.execute("insert into products values('"+product.getId()+"','"+product.getName()+"','"+product.getPrice()+"')");  
		return product;
	}

	public List<Product> listAll() {
		// TODO Auto-generated method stub
		System.out.println("Came inside the list all method of ProductDAOImpl");
		List<Product> productList = jdbcTemplate.query("select * from products", 
				(rs,rowNum) -> new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		return productList;
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Came inside the findbyId method of ProductDAOImpl");
		String sql = "select * from products where id="+id;
		return jdbcTemplate.queryForObject(sql,(rs,rowNum)->{
				Product product = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				return product;
			});
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from products where id=?";
		jdbcTemplate.update(sql,id);
	}

	public void updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		String sql = "update products set name=?,price=? where id=?";
		jdbcTemplate.update(sql,product.getName(), product.getPrice(),product.getId());
	}
	
	
}
