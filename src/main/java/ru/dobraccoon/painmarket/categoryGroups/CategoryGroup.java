package ru.dobraccoon.painmarket.categoryGroups;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryGroup {
    private Long id;
    private long catalogId;
    private String name;
}
