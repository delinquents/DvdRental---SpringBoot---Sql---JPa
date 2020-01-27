package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Address implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8937712312082870989L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id" ,  unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "district", nullable = false)
	private String district;
	
	@Column(name = "phone" , nullable = false)
	private String phone;
	
	@Column(name = "postal_code")
	private String postal_code;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "city_id" , nullable = false)	
	private City city;
	

	
	@OneToMany( mappedBy = "address",
			fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)	
    @JsonIgnore
	private List<Customer> customers = new ArrayList<Customer>();
	
	@OneToMany( mappedBy = "address",
			fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)	
    @JsonIgnore
	private List<Staff> staffs = new ArrayList<Staff>();
	
	

}
