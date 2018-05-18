package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
