package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entities.stringconverter.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Film  implements Serializable {

	
	private static final long serialVersionUID = -271716256873995183L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "release_year")
	private Integer release_year;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "language_id" , nullable = false)	
	private Language language;

	@Column(name = "rental_duration", nullable = false)
	private Double rental_duration;

	@Column(name = "rental_rate", nullable = false)
	private Double rental_rate;

	@Column(name = "length")
	private Integer length;

	@Column(name = "replacement_cost", nullable = false)
	private Integer replacement_cost;

	@Column(name = "rating")
	private String rating;

	@Column(name = "last_update", nullable = false)
	private Timestamp last_update;

	@Column(name = "special_features")
	@Convert(converter = StringListConverter.class)
	private ArrayList<String> special_features = new ArrayList<String>();

	@Column(name = "fulltext", nullable = false)
	private String fulltext;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "film_id")
	@JsonIgnore
	private List<FilmCategory> film_categories = new ArrayList<FilmCategory>();
	

	@OneToMany( mappedBy = "film",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)	
	@JsonIgnore
	private List<Inventory> invetories = new ArrayList<Inventory>();

}
