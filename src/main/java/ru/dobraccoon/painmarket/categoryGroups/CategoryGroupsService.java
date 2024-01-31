package ru.dobraccoon.painmarket.categoryGroups;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryGroupsService {
    CategoryGroupsRepository categoryGroupsRepository;

    public CategoryGroups loadById(long id) {
        return categoryGroupsRepository.loadById(id);
    }

    public void deleteById(long id) {
        categoryGroupsRepository.deleteById(id);
    }

    public void update(CategoryGroups categoryGroups) {
        categoryGroupsRepository.update(categoryGroups);
    }

    public void create(CategoryGroups newCategoryGroups) {
        categoryGroupsRepository.create(newCategoryGroups);
    }

    public List<CategoryGroups> loadByCategoryGroupsId(long catalogId) {
        return categoryGroupsRepository.loadByCategoryGroupsId(catalogId);
    }
}
