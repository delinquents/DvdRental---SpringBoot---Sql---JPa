package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Inventory;
import com.example.demo.entities.Store;

public interface StoreService {

	List<Inventory> getAllInventories(Integer page, Integer limit);

	List<Store> getAllStores();
	
	boolean isInvetoryInStock(int id);
}
