package com.example.demo.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Inventory;
import com.example.demo.entities.Store;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.StoreRepository;
import com.example.demo.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private  EntityManager em;

//	public List<Inventory> getAllInventories() {		
//		
//		List<Inventory> inventories = inventoryRepository.findAll();
//		
//		return inventories;
//	}

	public List<Inventory> getAllInventories(Integer page, Integer limit) {

		Pageable pagingRequest = (Pageable) PageRequest.of(page, limit);
		Page<Inventory> pagedResult = inventoryRepository.findAll(pagingRequest);

		return pagedResult.getContent();
	}

	public List<Store> getAllStores() {

		List<Store> stores = storeRepository.findAll();

		return stores;
	}

	
	
	@Override
	public boolean isInvetoryInStock(int id) {
		
		 StoredProcedureQuery procedureQuery = em.createStoredProcedureQuery("inventory_in_stock");
		 
		 procedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
		 procedureQuery.setParameter("id", id);
		 procedureQuery.execute();
		
		 Object result = procedureQuery.getSingleResult();
		 System.out.println(result);
		 
		return (Boolean)result;
	}

}
