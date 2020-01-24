package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	public List<Category> getAllCategories() {
		
	 List<Category> categories = this.categoryRepository.findAll(); 	
	 
	 	return categories;
	 	
	}
	
	
	
	
	
}
