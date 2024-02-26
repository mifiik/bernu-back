package ru.dobraccoon.painmarket.catalog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Catalog {
    @Setter
    private Long id;
    private String name;
}
