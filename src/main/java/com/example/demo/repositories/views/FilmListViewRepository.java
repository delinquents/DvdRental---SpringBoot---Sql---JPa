package com.example.demo.repositories.views;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.views.FilmListView;

@Repository
public interface FilmListViewRepository extends JpaRepository<FilmListView, Integer>{

}
