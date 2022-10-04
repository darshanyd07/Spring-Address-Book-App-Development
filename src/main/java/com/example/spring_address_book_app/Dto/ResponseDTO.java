package com.example.spring_address_book_app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok Library
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO
{
    private String message;
    private Object data;
}