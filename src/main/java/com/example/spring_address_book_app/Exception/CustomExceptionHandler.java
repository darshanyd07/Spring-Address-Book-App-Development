package com.example.spring_address_book_app.Exception;

import com.example.spring_address_book_app.Dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler
{
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(CustomException exception)
    {
        ResponseDTO responseDTO = new ResponseDTO("Exception while parsing Rest request", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}