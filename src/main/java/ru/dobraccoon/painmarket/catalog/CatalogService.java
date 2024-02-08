package ru.dobraccoon.painmarket.catalog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService {
    CatalogRepository catalogRepository;

    public List<Catalog> loadAll() {
        return catalogRepository.loadAll();
    }

    public Catalog loadById(long id) {
        return catalogRepository.loadById(id);
    }

    public void deleteById(long id) {
        catalogRepository.deleteById(id);
    }

    public void update(Catalog catalog) {
        catalogRepository.update(catalog);
    }

    public void create(Catalog newCatalog) {
        catalogRepository.update(newCatalog);
    }
}
