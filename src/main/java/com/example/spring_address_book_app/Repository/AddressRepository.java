package com.example.spring_address_book_app.Repository;

import com.example.spring_address_book_app.Entity.Address_Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository  extends JpaRepository<Address_Book, Integer>
{
    @Query("select u from Address_Book u where u.firstName =:c")
    List<Address_Book> getUsersByFirstName(@Param("c") String firstName);
//    @Query(value = "select * from address_book where is_active = 'Y' ",nativeQuery = true)
    @Query("select u from Address_Book u where u.isActive =:c")
    List<Address_Book> getActiveUsers(@Param("c") String isActive);

    @Query("select u from Address_Book u where u.penalty >= :c ")
    List<Address_Book> getPenaltyPerson(@Param("c") int penalty);
}