package ru.dobraccoon.painmarket.categoryGroups;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("categoryGroup")
public class CategoryGroupsController {
    CategoryGroupsService categoryGroupsService;

    @GetMapping("{id}")
    public CategoryGroups loadById(@PathVariable long id) {
        return categoryGroupsService.loadById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        categoryGroupsService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody CategoryGroups categoryGroups) {
        categoryGroupsService.update(categoryGroups);
    }

    @PostMapping
    public void create(@RequestBody CategoryGroups newCategoryGroups) {
        categoryGroupsService.create(newCategoryGroups);
    }

    @GetMapping("/load-by-catalog-id/{catalogId}")
    public List<CategoryGroups> loadByCategoryGroupsId(@PathVariable long catalogId) {
        return categoryGroupsService.loadByCategoryGroupsId(catalogId);
    }
}
