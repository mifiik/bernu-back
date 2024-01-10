package ru.dobraccoon.painmarket.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private long id;
    private String imageUrl;
    private boolean lawEntity;
    private String email;
    private int PhoneCountryCode;
    private int phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String city;
    private String street;
    private int cityIndex;
}
