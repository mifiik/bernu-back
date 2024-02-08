package ru.dobraccoon.painmarket.categories;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("{categoryId}")
    public Category loadById(@PathVariable long categoryId) {
        return categoryService.loadById(categoryId);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        categoryService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }

    @PostMapping
    public void create(@RequestBody Category newCategory) {
        categoryService.create(newCategory);
    }

    @GetMapping("/load-by-group-id/{categoryGroupId}")
    public List<Category> loadByGroupId(@PathVariable long categoryGroupId) {
        return categoryService.loadByGroupId(categoryGroupId);
    }

    @GetMapping("/load-by-catalog-id/{catalogId}")
    public List<Category> loadByCatalogId(@PathVariable long catalogId) {
        return categoryService.loadByCatalogId(catalogId);
    }
}
