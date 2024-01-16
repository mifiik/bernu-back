package com.dobraccon.painmarket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private final Long id;
    private final String email;
}
