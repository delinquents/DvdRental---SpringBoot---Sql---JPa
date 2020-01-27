package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Inventory;

import com.example.demo.entities.Store;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	

	
	public List<Inventory> getAllInventories() {		
		
		List<Inventory> inventories = inventoryRepository.findAll();
		
		return inventories;
	}
	
public List<Store> getAllStores() {		
		
		List<Store> stores = storeRepository.findAll();
		
		return stores;
	}
	
}
