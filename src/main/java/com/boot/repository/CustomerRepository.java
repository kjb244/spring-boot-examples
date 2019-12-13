package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("FROM Customer where lastName = ?1")
    List<Customer> findByLastName(String lastName);

    @Query(value = "SELECT distinct c.first_Name FROM Customer c, address_info a where c.id = a.customer_info_id and a.address_line_1 = :aLineOne", nativeQuery = true)
    List<String> findNamesWhereAddressLineOneMatches(@Param("aLineOne") String aLineOne);


}
