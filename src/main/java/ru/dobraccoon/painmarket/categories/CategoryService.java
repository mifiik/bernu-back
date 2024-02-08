package ru.dobraccoon.painmarket.categories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category loadById(long categoryId) {
        return categoryRepository.loadById(categoryId);
    }


    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    public void update(Category category) {
        categoryRepository.update(category);
    }

    public Category create(Category newCategory) {
        return categoryRepository.create(newCategory);
    }

    public List<Category> loadByGroupId(long categoryGroupId) {
        return categoryRepository.loadByGroupId(categoryGroupId);
    }

    public List<Category> loadByCatalogId(long catalogId) {
        return categoryRepository.loadByCatalogId(catalogId);
    }
}
