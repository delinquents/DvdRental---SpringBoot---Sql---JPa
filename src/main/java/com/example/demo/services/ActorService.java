package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Actor;
import com.example.demo.repositories.ActorRepository;

@Service
public class ActorService {
	
  @Autowired
  ActorRepository actorRepository;
	
	
  public List<Actor> getAllActors(Integer page, Integer limit) {	  
	  
	  Pageable pagingRequest = (Pageable) PageRequest.of(page,limit);
	  Page<Actor> pagedResult = actorRepository.findAll(pagingRequest);
	  
	  return pagedResult.getContent();
  }
  
  
  
	
}
