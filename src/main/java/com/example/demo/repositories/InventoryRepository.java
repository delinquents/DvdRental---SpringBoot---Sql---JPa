package com.example.demo.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Inventory;



@Repository
public interface InventoryRepository  extends PagingAndSortingRepository<Inventory, Integer>  {

}
