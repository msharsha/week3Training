package com.sapient.productservice.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productservice.model.Product;
import com.sapient.productservice.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:8080/products-rest-demo/api/v1/products/ ----URL

@RestController
@RequestMapping("/api/v1/products")
@PropertySource("classpath:documentation.properties")
public class ProductsController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Fetch all employees",notes = "API to fetch all the employees")
	public List<Product> listAll(){
		return productService.listAll();
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Product findById(@ApiParam(value="${ProductController.FetchByID}",required = true)@PathVariable("id") int id) {
		return productService.findById(id);
	}
	
	@PostMapping(value="/", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public String saveProduct(@ApiParam(value="${ProductController.save}",required = true)@Valid @RequestBody Product product) {
		productService.saveProduct(product);
		return "Product Saved";
	}
	
	@PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public String updateProduct(@ApiParam(value="${ProductController.update}",required = true)@PathVariable("id") int id, @RequestBody Product product) {
		productService.updateProduct(id, product);
		return "Product updated";
		
	}
	
	@DeleteMapping(value = "/{id}")
	public String deleteProduct(@ApiParam(value="${ProductController.delete}",required = true)@PathVariable("id")int id) {
		productService.deleteProduct(id);
		return "Product deleted";
	}
	
}
