package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Staff;
import com.example.demo.repositories.StaffRepository;
import com.example.demo.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	
	public List<Staff> getAllStaffs() {
		
		
		List<Staff> staffs = staffRepository.findAll();
		
		return staffs;
	}
	
}
