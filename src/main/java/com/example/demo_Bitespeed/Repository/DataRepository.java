package com.example.demo_Bitespeed.Repository;

import com.example.demo_Bitespeed.Enitity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Model, Integer> {
    @Query(value = "SELECT * FROM result s WHERE s.phone_number = :phoneNumber LIMIT 1",
            nativeQuery = true)
    Model findByPhoneNumber(@Param("phoneNumber")String phoneNumber);
    @Query(value= "SELECT * FROM result s WHERE s.email = :email LIMIT 1",
            nativeQuery = true)
    Model findByEmail(@Param("email") String email);
}
