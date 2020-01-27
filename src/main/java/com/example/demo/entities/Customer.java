package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -910352850503590664L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	@Column(name = "first_name", nullable = false)
	private String first_name;

	@Column(name = "last_name", nullable = false)
	private String last_name;

	@Column(name = "email")
	private String email;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	@Column(name = "activebool", nullable = false)
	private Boolean activebool;

	@Column(name = "create_date")
	private Date create_date;

	@Column(name = "last_update", nullable = false)
	private Timestamp last_update;

	@Column(name = "active")
	private Integer active;

}
