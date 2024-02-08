package ru.dobraccoon.painmarket.categoryGroups;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CategoryGroup {
    @Setter
    private Long id;
    private long catalogId;
    private String name;
}
