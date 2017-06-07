package com.MobiShop.MobiShopBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="supplier")
public class Supplier {
	
	@Id
	int suppid;
	
	String suppname, address;

	public int getSuppid() {
		return suppid;
	}

	public void setSuppid(int suppid) {
		this.suppid = suppid;
	}

	public String getSuppname() {
		return suppname;
	}

	public void setSuppname(String suppname) {
		this.suppname = suppname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
