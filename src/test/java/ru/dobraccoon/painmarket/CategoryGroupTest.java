package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.catalog.Catalog;
import ru.dobraccoon.painmarket.catalog.CatalogService;
import ru.dobraccoon.painmarket.categoryGroups.CategoryGroup;
import ru.dobraccoon.painmarket.categoryGroups.CategoryGroupService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoryGroupTest {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CategoryGroupService categoryGroupService;
    private CategoryGroup createdCategoryGroup;
    private Catalog testCatalog;

    @BeforeAll
    public void initTestData() {
        testCatalog = catalogService.create(new Catalog(null,
                "CatalogTestName"));
    }

    @AfterAll
    public void deleteInitData() {
        categoryGroupService.deleteById(createdCategoryGroup.getId());
        catalogService.deleteById(testCatalog.getId());
    }

    @Test
    public void createTest() {
        createdCategoryGroup = categoryGroupService.create(new CategoryGroup(null,
                testCatalog.getId(),
                "CategoryGroupTestName"));

        Assertions.assertNotNull(createdCategoryGroup);
        Assertions.assertNotNull(categoryGroupService.loadById(createdCategoryGroup.getId()));
    }
}
