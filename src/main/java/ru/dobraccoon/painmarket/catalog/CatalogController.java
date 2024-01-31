package ru.dobraccoon.painmarket.catalog;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("catalog")
public class CatalogController {
    CatalogService catalogService;

    @GetMapping("load-all")
    public List<Catalog> loadAll() {
        return catalogService.loadAll();
    }

    @GetMapping("{id}")
    public Catalog loadById(@PathVariable long id) {
        return catalogService.loadById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        catalogService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Catalog catalog) {
        catalogService.update(catalog);
    }

    @PostMapping
    public void create(@RequestBody Catalog newCatalog) {
        catalogService.create(newCatalog);
    }
}