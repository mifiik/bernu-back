package ru.dobraccoon.painmarket.categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Category {
    @Setter
    private Long id;
    private long categoryGroupId;
    private String name;
}
