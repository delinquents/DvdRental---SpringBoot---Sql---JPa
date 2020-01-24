package com.example.demo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Category;


@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer>  {

}
