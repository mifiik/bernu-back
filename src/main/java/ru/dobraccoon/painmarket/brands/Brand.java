package ru.dobraccoon.painmarket.brands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Brand {
    @Setter
    Long id;
    private String imageUrl;
    private String name;
}
