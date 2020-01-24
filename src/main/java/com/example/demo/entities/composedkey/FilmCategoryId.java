package com.example.demo.entities.composedkey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class FilmCategoryId implements Serializable {

	private static final long serialVersionUID = 2442485204371571733L;
	
	
	@Column(name = "film_id")
	private Integer film_id;
	
	@Column(name = "category_id")
	private Integer category_id;

	
	public FilmCategoryId(Integer film_id, Integer category_id) {
		this.film_id = film_id;
		this.category_id = category_id;
	}
	
	
	public FilmCategoryId() {
		super();
	}


	public Integer getFilmId() {
        return film_id;
    }
 
    public Integer getCategoryId() {
        return category_id;
    }
	
	  public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof FilmCategoryId)) return false;
	        FilmCategoryId that = (FilmCategoryId) o;
	        return Objects.equals(getFilmId(), that.getFilmId()) &&
	                Objects.equals(getCategoryId(), that.getCategoryId());
	    }
	  
	  @Override
	    public int hashCode() {
	        return Objects.hash(getFilmId(), getCategoryId());
	    }
}
