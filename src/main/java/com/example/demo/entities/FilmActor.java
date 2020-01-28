package com.example.demo.entities;



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

import com.example.demo.entities.composedkey.FilmActorId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film_actor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilmActor {

	
	
	
	@EmbeddedId
	private FilmActorId id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	@JsonIgnore
	private Film film_id;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
	@JsonIgnore
	private Actor actor_id;
	
	
	@Basic(optional = false)
	@Column(name = "last_update", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
