package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.FilmCategory;


@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Integer> {

}
