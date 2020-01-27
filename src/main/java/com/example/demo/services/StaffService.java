package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Staff;
import com.example.demo.repositories.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	
	public List<Staff> getAllStaffs() {
		
		
		List<Staff> staffs = staffRepository.findAll();
		
		return staffs;
	}
	
}
