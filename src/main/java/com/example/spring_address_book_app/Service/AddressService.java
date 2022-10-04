package com.example.spring_address_book_app.Service;

import com.example.spring_address_book_app.Dto.AddressDto;
import com.example.spring_address_book_app.Entity.Address_Book;
import com.example.spring_address_book_app.Exception.CustomException;
import com.example.spring_address_book_app.Repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressService implements IAddressService
{
    @Autowired
    AddressRepository addressRepository;

    public Address_Book addData(Address_Book Book)
    {
        log.info("-----------Person Data Add Successfully ------------");
        return addressRepository.save(Book);

    }

    public List<Address_Book> getAllDetiles()
    {
        if (addressRepository.findAll().isEmpty())
        {
            log.info("-----------No Person In Database.------------");
            throw new CustomException("No Person In Database.");

        } else return addressRepository.findAll();

    }
    public Optional<Address_Book> getById(int id)
    {
        if (addressRepository.findById(id).isPresent())
        {
            log.info("--------- Person Id :- " + id + " Show Successfully -----------");
            return addressRepository.findById(id);

        } else throw new CustomException("No Person matches with the given ID");
    }

    public String deleteById(int id)
    {
        if (addressRepository.findById(id).isPresent())
        {
            addressRepository.deleteById(id);
            log.info("---------Person Id :- " + id + " Delete Successfully -----------");
            return "Person with ID: " + id + " is Deleted Successfully!!";
        } else throw new CustomException("No Person matches with the given ID");
    }

    public String editEmployee(AddressDto addressDTO, int id)
    {
        if (addressRepository.findById(id).isPresent())
        {
            Address_Book book1 = new Address_Book(id, addressDTO);
            Address_Book alpha = addressRepository.save(book1);
            log.info("----------- Person Id " + id + " Data Update Successfully ------------");
            return "This is the result" + alpha;
        } else throw new CustomException("No Person matches with the given ID");
    }


    public List<Address_Book> getUsersByFirstName(String firstName)
    {
        if (addressRepository.getUsersByFirstName(firstName).isEmpty())
        {

            log.info("----------- No First Name Present In Database.------------");
            throw new CustomException("No First Name Present In Database.");

        } else return addressRepository.getUsersByFirstName(firstName);

    }

    public List<Address_Book> getActiveUsers(String isActive)
    {
        if (addressRepository.getActiveUsers(isActive).isEmpty())
        {

            log.info("----------- No Active Person  Present In Database.------------");
            throw new CustomException("No Active Person  Present In Database.");

        } else return addressRepository.getActiveUsers(isActive);

    }

    public List<Address_Book> getPenaltyPerson(int penalty)
    {
        if (addressRepository.getPenaltyPerson(penalty).isEmpty())
        {

            log.info("----------- No "+penalty+" More Than Penalty  Persons  In Database.------------");
            throw new CustomException("No "+penalty+" More Than Penalty  Persons  In Database.");

        } else return addressRepository.getPenaltyPerson(penalty);
    }

}
