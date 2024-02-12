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
import ru.dobraccoon.painmarket.customer.Customer;
import ru.dobraccoon.painmarket.customer.CustomerService;
import ru.dobraccoon.painmarket.feedback.Feedback;
import ru.dobraccoon.painmarket.feedback.FeedbackService;
import ru.dobraccoon.painmarket.products.Product;
import ru.dobraccoon.painmarket.products.ProductService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FeedbackTest {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CategoryGroupService categoryGroupService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private FeedbackService feedbackService;
    private Catalog testCatalog;
    private CategoryGroup testCategoryGroup;
    private Category testCategory;
    private Customer testCustomer;
    private Product testProduct;
    private Feedback createdFeedback;

    @BeforeAll
    public void initTestData() {
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
        testCustomer = customerService.create(new Customer(
                null,
                "imageUrlTest",
                true,
                "emailTest",
                4900,
                79652796,
                "firstNameTest",
                "lastNameTest",
                "passwordTest",
                "cityTest",
                "streetTest",
                6100
        ));
        testProduct = productService.create(new Product(
                null,
                55.23F,
                65.54F,
                5,
                true,
                "imageUrlTest",
                "descriptionTest",
                2,
                22,
                4.5F,
                78,
                testCategory.getId()
        ));
    }

    @AfterAll
    public void deleteData() {
        feedbackService.deleteById(createdFeedback.getId());
        productService.deleteById(testProduct.getId());
        customerService.deleteById(testCustomer.getId());
        categoryService.deleteById(testCategory.getId());
        categoryGroupService.deleteById(testCategoryGroup.getId());
        catalogService.deleteById(testCatalog.getId());

    }

    @Test
    public void createTest() {
        createdFeedback = feedbackService.create(new Feedback(
                null,
                testCustomer.getId(),
                testProduct.getId(),
                null,
                "captionTest",
                "feedbackTest",
                5
        ));

        Assertions.assertNotNull(createdFeedback);
        Assertions.assertNotNull(feedbackService.loadById(createdFeedback.getId()));
    }
}
