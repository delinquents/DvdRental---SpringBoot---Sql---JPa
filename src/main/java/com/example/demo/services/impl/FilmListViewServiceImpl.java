package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.views.FilmListView;
import com.example.demo.repositories.views.FilmListViewRepository;
import com.example.demo.service.FilmListViewService;



@Service
public class FilmListViewServiceImpl implements FilmListViewService {

	@Autowired
	private FilmListViewRepository filmListViewRepository;
	
	
	@Override
	public List<FilmListView> getListOfFIlms() {

		List<FilmListView> filmsView = filmListViewRepository.findAll();
		
		return filmsView;
	}

}
