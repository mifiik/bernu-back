package ru.dobraccoon.painmarket.categoryGroups;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryGroupService {
    CategoryGroupRepository categoryGroupRepository;

    public CategoryGroup loadById(long id) {
        return categoryGroupRepository.loadById(id);
    }

    public void deleteById(long id) {
        categoryGroupRepository.deleteById(id);
    }

    public void update(CategoryGroup categoryGroup) {
        categoryGroupRepository.update(categoryGroup);
    }

    public void create(CategoryGroup newCategoryGroup) {
        categoryGroupRepository.create(newCategoryGroup);
    }

    public List<CategoryGroup> loadByCategoryGroupsId(long catalogId) {
        return categoryGroupRepository.loadByCategoryGroupsId(catalogId);
    }
}
