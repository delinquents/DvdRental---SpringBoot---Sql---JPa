package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;


import java.util.HashSet;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "language")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Language  implements Serializable {

	
	private static final long serialVersionUID = 655393983951552693L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id", unique = true,nullable = false)
	private Integer id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "last_update", nullable = false)
	private Timestamp last_update;

	
	@OneToMany( mappedBy = "language",
				fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)	
	@JsonIgnore
	private Set<Film> films = new HashSet<Film>();
	   
	   
	   
	   
	   @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Language )) return false;
	        return id != null && id.equals(((Language) o).getId());
	    }
	 
	    @Override
	    public int hashCode() {
	        return 31;
	    }
	   
	   
	   
	   
	   
}
