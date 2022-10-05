package com.example.spring_address_book_app.Service;

import com.example.spring_address_book_app.Dto.AddressDto;
import com.example.spring_address_book_app.Entity.Address_Book;

import java.util.List;
import java.util.Optional;

public interface IAddressService
{
    Address_Book addData(Address_Book Book);
    List<Address_Book> getAllDetiles();
    Optional<Address_Book> getById(int id);

    String deleteById(int id);

    String editEmployee(AddressDto adressDTO, int id);

    List<Address_Book> getUsersByFirstName(String firstName);
    List<Address_Book> getActiveUsers(String isActive);

    List<Address_Book> getPenaltyPerson(int penalty);
    List<Address_Book> getPenaltyPersonLess(int penalty);
    List<Address_Book> UsersByCityName(String city);
//    List<Address_Book> findTopPenalty();
   // List<Address_Book> getCityState(String city,String state);
}
