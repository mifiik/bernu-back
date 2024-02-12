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
import ru.dobraccoon.painmarket.products.Product;
import ru.dobraccoon.painmarket.products.ProductService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductTest {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CategoryGroupService categoryGroupService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    private Catalog testCatalog;
    private CategoryGroup testCategoryGroup;
    private Category testCategory;
    private Product createdProduct;

    @BeforeAll
    public void initCatalogData() {
        testCatalog = catalogService.create(new Catalog(
                null,
                "nameTest"
        ));

        testCategoryGroup = categoryGroupService.create(new CategoryGroup(
                null,
                testCatalog.getId(),
                "nameTest"
        ));

        testCategory = categoryService.create(new Category(
                null,
                testCategoryGroup.getId(),
                "nameTest"
        ));
    }

    @AfterAll
    public void deleteInitData() {
        productService.deleteById(createdProduct.getId());
        categoryService.deleteById(testCategory.getId());
        categoryGroupService.deleteById(testCategoryGroup.getId());
        catalogService.deleteById(testCatalog.getId());
    }

    @Test
    public void createTest() {
        createdProduct = productService.create(new Product(
                null,
                33.4F,
                54.1F,
                5,
                false,
                "imageUrlTest",
                "descriptionTest",
                3,
                7,
                4.5F,
                45,
                testCategory.getId()
        ));

        Assertions.assertNotNull(createdProduct);
        Assertions.assertNotNull(productService.loadById(createdProduct.getId()));
    }
}
