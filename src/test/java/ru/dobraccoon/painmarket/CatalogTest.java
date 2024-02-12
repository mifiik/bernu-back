package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.catalog.Catalog;
import ru.dobraccoon.painmarket.catalog.CatalogService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatalogTest {
    @Autowired
    private CatalogService catalogService;

    private Catalog createdCatalog;

    @AfterAll
    public void deleteTestData() {
        catalogService.deleteById(createdCatalog.getId());
    }

    @Test
    public void createTest() {
        createdCatalog = catalogService.create(new Catalog(null, "testName"));

        Assertions.assertNotNull(createdCatalog);
        Assertions.assertNotNull(catalogService.loadById(createdCatalog.getId()));
    }
}
