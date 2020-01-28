package com.example.demo.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.Payment;

@Repository
public interface PaymentRepository  extends PagingAndSortingRepository<Payment, Integer> {

}
