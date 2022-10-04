package com.example.spring_address_book_app.Controller;

import com.example.spring_address_book_app.Dto.AddressDto;
import com.example.spring_address_book_app.Dto.ResponseDTO;
import com.example.spring_address_book_app.Entity.Address_Book;
import com.example.spring_address_book_app.Service.IAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/Address")
@RestController
public class AddressController
{
    @Autowired
    IAddressService iAddressService;

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createEmployees(@Valid @RequestBody AddressDto addressDTO)
    {
        Address_Book address1 = new Address_Book(addressDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Created Successfully", iAddressService.addData(address1));
        log.info("-----------Employee Data Add Successfully ------------");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAllDetiles()
    {
        ResponseDTO responseDTO = new ResponseDTO("Employee List Received Successfully", iAddressService.getAllDetiles());
        log.info("Get All Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ResponseDTO> getByID(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Person Received Successfully", iAddressService.getById(id));
        log.info("Get Employee Id : "+id+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Person Deleted Successfully", iAddressService.deleteById(id));
        log.info("Get Person Id : "+id+"  Data Delete Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@Valid @RequestBody AddressDto addressDTO, @PathVariable int id)
    {
        ResponseDTO responseDTO = new ResponseDTO("Employee Updated Successfully", iAddressService.editEmployee(addressDTO, id));
        log.info("Get Employee Id : "+id+"  Data Update Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getByName/{firstName}")
    public ResponseEntity<ResponseDTO> getUsersByFirstName(@PathVariable String firstName)
    {
        ResponseDTO responseDTO = new ResponseDTO(firstName+" Employee All Data Successfully.......", iAddressService.getUsersByFirstName(firstName));
        log.info("Get Employee Id : "+firstName+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/getActivePerson/{isActive}")
    public ResponseEntity<ResponseDTO> getActiveUsers(@PathVariable String isActive)
    {
        ResponseDTO responseDTO = new ResponseDTO(" All Active Person  Data Successfully.......", iAddressService.getActiveUsers(isActive));
        log.info("Get Person Id : "+isActive+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/GetMoreThenPenalty/{penalty}")
    public ResponseEntity<ResponseDTO> getPenaltyPerson(@PathVariable int penalty)
    {
        ResponseDTO responseDTO = new ResponseDTO(" All Active Person  Data Successfully.......", iAddressService.getPenaltyPerson(penalty));
        log.info("Get Person Id : "+penalty+"  Data Successfully.......");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
