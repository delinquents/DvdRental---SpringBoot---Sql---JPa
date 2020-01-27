package com.example.demo.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FilmEmbaddable {

	@Column(name="film_id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
}
