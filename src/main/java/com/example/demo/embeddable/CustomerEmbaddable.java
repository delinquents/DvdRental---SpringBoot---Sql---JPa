package com.example.demo.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerEmbaddable {
	
	@Column(name="customer_id")
	private Integer customer_id;
	
	@Column(name="store_id")
	private Integer store_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="address_id")
	private Integer address_id;
	
	@Column(name = "activebool")
	private Boolean activebool;

	@Column(name = "create_date")
	private String create_date;
	
	@Column(name = "last_update")
	private String last_update;
	
	@Column(name = "active")
	private Boolean active;
	
	
}
