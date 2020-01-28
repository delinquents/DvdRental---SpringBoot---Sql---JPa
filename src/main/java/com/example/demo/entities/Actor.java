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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter@Setter
@Table(name="actor")
@AllArgsConstructor
@NoArgsConstructor
public class Actor  implements Serializable {
	
	
	private static final long serialVersionUID = -5883841491291924737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="actor_id", unique = true,nullable = false)
	private Integer id;
	
	@Column(name = "first_name" ,nullable = false, length = 45)
	private String first_name;
	
	@Column(name = "last_name",nullable = false, length = 45 )
	private String last_name;
	
	@Column(name = "last_update" , nullable = false)	
	private Timestamp last_update;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "actor_id")
	@JsonIgnore
	private List<FilmActor> filmActors = new ArrayList<FilmActor>();
	
	
}
