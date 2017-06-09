package com.MobiShop.MobiShopBackend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Component
@Table(name="supplier")
public class Supplier {
	
	@Id
	private String id;
	@Column(unique = true, nullable=false)
	private String name;
	private String address;
	
	@OneToMany(mappedBy="supplier", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Product> products;
	
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	@Column(name = "ID")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
