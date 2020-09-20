package com.boot.repository;

import com.boot.model.AddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends JpaRepository<AddressInfo, Integer> {


    @Modifying
    @Transactional
    @Query("Update address_info a SET a.addressLine1=:addressLine1 where a.id=:id")
    void updateAddressLineOne(@Param("addressLine1") String addressLine1, @Param("id") int id);

}
