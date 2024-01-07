package com.dev.Shopezzy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin_model")
public class AdminModel {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long admin_id;
	
	@Column(name="admin_name")
	private String admin_name;
	
	@Column(name="admin_email")
	private String admin_email;
	
	@Column(name="admin_password")
	private String admin_password;
	
	@Column(name="admin_contact")
	private String admin_contact;
	
	@Column(name="admin_location")
	private String admin_location;
	
	
	
}
