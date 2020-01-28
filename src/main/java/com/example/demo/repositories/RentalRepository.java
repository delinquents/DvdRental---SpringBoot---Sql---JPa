package com.example.demo.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.Rental;

@Repository
public interface RentalRepository  extends PagingAndSortingRepository<Rental, Integer>  {

}
