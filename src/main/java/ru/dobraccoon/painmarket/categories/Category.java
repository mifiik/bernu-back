package ru.dobraccoon.painmarket.categories;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Category {
    private Long id;
    private long categoryGroupId;
    private String name;
}
