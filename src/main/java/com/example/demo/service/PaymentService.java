package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Payment;

public interface PaymentService {
	
	List<Payment> getAllPayments(Integer page, Integer limit);

}
