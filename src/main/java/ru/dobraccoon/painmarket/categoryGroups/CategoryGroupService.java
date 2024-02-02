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

    public CategoryGroup create(CategoryGroup newCategoryGroup) {
        return categoryGroupRepository.create(newCategoryGroup);
    }

    public List<CategoryGroup> loadByCategoryGroupId(long catalogId) {
        return categoryGroupRepository.loadByCategoryGroupId(catalogId);
    }
}
