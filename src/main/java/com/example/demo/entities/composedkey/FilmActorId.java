package com.example.demo.entities.composedkey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class FilmActorId implements Serializable  {
	
	

	private static final long serialVersionUID = -7803430666931408557L;
	


	@Column(name = "film_id")
	private Integer film_id;
	
	@Column(name = "actor_id")
	private Integer actor_id;

	
	
	
	  public FilmActorId( Integer film_id, Integer actor_id) {
		this.film_id = film_id;
		this.actor_id = actor_id;
	}
	  public FilmActorId() {
			super();
		}
	  
	public Integer getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}

	public Integer getActor_id() {
		return actor_id;
	}

	public void setActor_id(Integer actor_id) {
		this.actor_id = actor_id;
	}

	public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof FilmActorId)) return false;
	        FilmActorId that = (FilmActorId) o;
	        return Objects.equals(getFilm_id(), that.getFilm_id()) &&
	                Objects.equals(getActor_id(), that.getActor_id());
	    }
	  
	  @Override
	    public int hashCode() {
	        return Objects.hash(getFilm_id(), getActor_id());
	    }
	
	
	
	

}
