package com.sapient.productservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "products1")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable{
	
	
		@XmlElement
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@JsonProperty
		private int id;
		
		@XmlElement
		@Column(name="product_name")
		private String name;
		
		@XmlElement
		@Column(name="product_price")
		private double price;

		
		public Product() {
			
		}
		public Product(int id, String name, double price) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
}
