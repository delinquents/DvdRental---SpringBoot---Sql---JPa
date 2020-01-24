package com.example.demo.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Category implements Serializable {


	private static final long serialVersionUID = -3092883208243845073L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	
	
	 @OneToMany(mappedBy = "category_id")
	 Set<Category> category_id = new HashSet<Category>();
	 
	@Basic(optional = false)
	@Column(name = "last_update", insertable = false, updatable = false)	
	private Date last_update;
	 
}
