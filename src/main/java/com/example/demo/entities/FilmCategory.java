package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.entities.composedkey.FilmCategoryId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FilmCategory implements Serializable {

	private static final long serialVersionUID = -2398564918360703456L;

	@EmbeddedId
	private FilmCategoryId id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	@JsonIgnore
	private Film film_id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
	@JsonIgnore
	private Category category_id;

	@Basic(optional = false)
	@Column(name = "last_update", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;

}
