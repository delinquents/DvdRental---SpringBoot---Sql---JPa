package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

	private static final long serialVersionUID = -3092883208243845073L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

//	
//	 @OneToMany(mappedBy = "category_id")
//	 Set<Category> category_id = new HashSet<Category>();

	@Basic(optional = false)
	@Column(name = "last_update", nullable = false, insertable = false, updatable = false)
	private Timestamp last_update;

}
