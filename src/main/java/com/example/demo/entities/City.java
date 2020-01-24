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
@Table(name = "city")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class City implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7176588665995352603L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Integer id;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "country_id" , nullable = false)	
	private Country country;
	
	
	@Column(name = "last_update", nullable = false)
	private Timestamp last_update;
	
	
	
	
	
	
	
	
	

}
