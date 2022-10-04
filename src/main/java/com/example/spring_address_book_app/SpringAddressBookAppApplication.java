package com.example.spring_address_book_app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class SpringAddressBookAppApplication {

    public static void main(String[] args)
    {
        System.out.println("----------- Welcome To Address Book App ------------");
        log.info("----------- Welcome To Address Book  Spring App ------------");
        SpringApplication.run(SpringAddressBookAppApplication.class, args);
    }

}
