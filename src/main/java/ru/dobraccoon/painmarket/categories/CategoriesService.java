package ru.dobraccoon.painmarket.categories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public Categories loadById(long categoriesId) {
        return categoriesRepository.loadById(categoriesId);
    }

    public List<Categories> loadAll() {
        return categoriesRepository.loadAll();
    }

    public void deleteById(long id) {
        categoriesRepository.deleteById(id);
    }

    public void update(Categories categories) {
        categoriesRepository.update(categories);
    }

    public void create(Categories newCategories) {
        categoriesRepository.create(newCategories);
    }

    public List<Categories> loadByGroupId(long categoryGroupsId) {
        return categoriesRepository.loadByGroupId(categoryGroupsId);
    }

    public List<Categories> loadByCatalogId(long catalogId) {
        return categoriesRepository.loadByCatalogId(catalogId);
    }
}
