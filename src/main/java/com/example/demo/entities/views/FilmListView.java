package com.example.demo.entities.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film_list")
@Immutable
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmListView {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fid")
	private Integer filmId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String text;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "length")
	private Integer length;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "actors")
	private String actors;
	
}
