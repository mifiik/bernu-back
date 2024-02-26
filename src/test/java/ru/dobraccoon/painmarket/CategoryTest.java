package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.catalog.Catalog;
import ru.dobraccoon.painmarket.catalog.CatalogService;
import ru.dobraccoon.painmarket.categories.Category;
import ru.dobraccoon.painmarket.categories.CategoryService;
import ru.dobraccoon.painmarket.categoryGroups.CategoryGroup;
import ru.dobraccoon.painmarket.categoryGroups.CategoryGroupService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoryTest {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    CategoryGroupService categoryGroupService;


    private Category createdCategory;

    Catalog testCatalog;

    CategoryGroup testCategoryGroup;

    @BeforeAll
    public void initTestData() {

        testCatalog = catalogService.create(new Catalog(
                null,
                "testName"
        ));
        testCategoryGroup = categoryGroupService.create(new CategoryGroup(
                null,
                testCatalog.getId(),
                "testCategoryGroupName"
        ));
    }

    @AfterAll
    public void deleteTestData() {
        categoryService.deleteById(createdCategory.getId());
        categoryGroupService.deleteById(testCategoryGroup.getId());
        catalogService.deleteById(testCatalog.getId());
    }

    @Test
    public void createdTest() {
        createdCategory = categoryService.create(new Category(null, testCategoryGroup.getId(), "testCategory"));

        Assertions.assertNotNull(createdCategory);
        Assertions.assertNotNull(categoryService.loadById(createdCategory.getId()));
    }
}
