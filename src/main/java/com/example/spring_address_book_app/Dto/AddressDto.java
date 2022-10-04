package com.example.spring_address_book_app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto
{
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee First Name is Invalid")
    public String firstName;

    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee Last Name is Invalid")
    public String lastName;

    @NotEmpty(message = "Address Can Not Empty")
    public String address;

    @NotEmpty(message = "City Can Not Empty")
    public String city;

    @NotBlank(message = "State Can Not Empty")
    public String state;

    @Pattern(regexp ="^[0-9]{6}$", message = "Zip Code should be a 6 digit number.")
    @NotBlank(message = "Zip Code Can Not Empty")
    public String zip_code;

    @Pattern(regexp ="^[0-9]{10}$", message = "Phone number should be a 10 digit number.")
    public String mobile_Number;


    @NotEmpty(message = "Notes Can Not Empty")
    public String notes;

    @NotEmpty(message = "Status Of Person  Can Not Empty")
    public String isActive;


    @Min(value = 500,message = "Plz Give Greater Then 500 Penalty To Person......")
    @Max(value = 5000,message = "Plz Give Less Then 5000 Penalty To Person......")
    public int penalty;
}
