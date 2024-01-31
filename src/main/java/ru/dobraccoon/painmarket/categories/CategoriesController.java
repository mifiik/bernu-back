package ru.dobraccoon.painmarket.categories;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("category")
public class CategoriesController {
    private final CategoriesService categoriesService;

    @GetMapping("{categoriesId}")
    public Categories loadById(@PathVariable long categoriesId) {
        return categoriesService.loadById(categoriesId);
    }

    @GetMapping("load-all")
    public List<Categories> loadAll() {
        return categoriesService.loadAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        categoriesService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Categories categories) {
        categoriesService.update(categories);
    }

    @PostMapping
    public void create(@RequestBody Categories newCategories) {
        categoriesService.create(newCategories);
    }

    @GetMapping("/load-by-group-id/{categoryGroupsId}")
    public List<Categories> loadByGroupId(@PathVariable long categoryGroupsId) {
        return categoriesService.loadByGroupId(categoryGroupsId);
    }

    @GetMapping("/load-by-catalog-id/{catalogId}")
    public List<Categories> loadByCatalogId(@PathVariable long catalogId) {
        return categoriesService.loadByCatalogId(catalogId);
    }
}
