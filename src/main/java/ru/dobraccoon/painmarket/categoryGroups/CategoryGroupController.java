package ru.dobraccoon.painmarket.categoryGroups;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("categoryGroup")
public class CategoryGroupController {
    CategoryGroupService categoryGroupService;

    @GetMapping("{id}")
    public CategoryGroup loadById(@PathVariable long id) {
        return categoryGroupService.loadById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        categoryGroupService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody CategoryGroup categoryGroup) {
        categoryGroupService.update(categoryGroup);
    }

    @PostMapping
    public void create(@RequestBody CategoryGroup newCategoryGroup) {
        categoryGroupService.create(newCategoryGroup);
    }

    @GetMapping("/load-by-catalog-id/{catalogId}")
    public List<CategoryGroup> loadByCategoryGroupsId(@PathVariable long catalogId) {
        return categoryGroupService.loadByCategoryGroupsId(catalogId);
    }
}
