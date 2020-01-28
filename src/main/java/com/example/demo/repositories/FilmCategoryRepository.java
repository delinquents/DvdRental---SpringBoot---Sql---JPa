package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.FilmCategory;
import com.example.demo.entities.composedkey.FilmCategoryId;


@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId> {
	
//	public List<FilmCategory>  findByFilm_Id(Integer id);
//	public List<FilmCategory>  findByCategory_Id(Integer id);

}
