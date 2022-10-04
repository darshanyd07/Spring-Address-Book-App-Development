package com.example.spring_address_book_app.Exception;

public class CustomException extends RuntimeException
{
    public CustomException(String message)
    {
        super(message);
    }
}