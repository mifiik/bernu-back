package ru.dobraccoon.painmarket.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Customer {
    @Setter
    private Long id;
    private String imageUrl;
    private boolean lawEntity;
    private String email;
    private int phoneCountryCode;
    private int phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String city;
    private String street;
    private int cityIndex;
}
