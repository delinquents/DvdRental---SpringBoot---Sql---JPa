package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Inventory  implements Serializable  {
	
	
	
	private static final long serialVersionUID = -2325609464885482946L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id", unique = true, nullable = false)
	private Integer id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "film_id" , nullable = false)	
	private Film film;
	

	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "store_id" , nullable = false)
	private Store store;
	

	
	@Column(name = "last_update" , nullable = false)	
	private Timestamp last_update;

}
