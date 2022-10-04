package com.example.spring_address_book_app.Entity;

import com.example.spring_address_book_app.Dto.AddressDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Address_Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip_code;
    public String mobile_Number;
    public String notes;
    public String isActive;

    public int penalty;

    public Address_Book()
    {
    }

    public Address_Book(int id, AddressDto adressDTO)
    {
        this.id = id;
        this.firstName = adressDTO.firstName;
        this.lastName = adressDTO.lastName;
        this.address = adressDTO.address;
        this.city = adressDTO.city;
        this.state = adressDTO.state;
        this.zip_code = adressDTO.zip_code;
        this.mobile_Number = adressDTO.mobile_Number;
        this.notes = adressDTO.notes;
        this.isActive = adressDTO.isActive;
        this.penalty = adressDTO.penalty;

    }

    public Address_Book(AddressDto adressDTO)
    {

        this.firstName = adressDTO.firstName;
        this.lastName = adressDTO.lastName;
        this.address = adressDTO.address;
        this.city = adressDTO.city;
        this.state = adressDTO.state;
        this.zip_code = adressDTO.zip_code;
        this.mobile_Number = adressDTO.mobile_Number;
        this.notes = adressDTO.notes;
        this.isActive = adressDTO.isActive;
        this.penalty = adressDTO.penalty;
    }
}
