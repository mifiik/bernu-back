package com.dobraccon.painmarket;

import com.dobraccon.painmarket.docker.AbstractPostgresContainer;
import com.dobraccon.painmarket.products.Product;
import com.dobraccon.painmarket.products.ProductController;
import com.dobraccon.painmarket.util.RandomProduct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest extends AbstractPostgresContainer {
    @Autowired
    ProductController controller;
    Product randomProduct;
    String expectedName;

    @BeforeEach
    public void setUp() {
        randomProduct = RandomProduct.getRandomProduct();
    }

    @AfterEach
    public void tearDown() {
        if (expectedName != null) {
            controller.deleteByName(expectedName);
        }
    }

    @Test
    public void testingTheMethodsToSaveProductAndFindById() {
        expectedName = randomProduct.getName();
        Long id = controller.saveProduct(randomProduct);
        Product actualProduct = controller.findById(id);

        assertThat(actualProduct.getName()).isEqualTo(expectedName);
    }

    @Test
    public void testingTheMethodToFindAll() {
        List<Product> products = controller.findAll();

        assertThat(products.size()).isEqualTo(5);
    }

    @Test
    public void testingTheMethodToFindByDiscount() {
        expectedName = randomProduct.getName();
        int expectedDiscount = randomProduct.getDiscount();
        Long id = controller.saveProduct(randomProduct);
        Product product = controller.findById(id);
        List<Product> actualProducts = controller.findByDiscount(expectedDiscount);

        actualProducts.forEach(x -> assertThat(x.getDiscount()).isIn(product.getDiscount()));
    }

    @Test
    public void testingTheMethodToUpdateProduct() {
        expectedName = randomProduct.getName();
        Long id = controller.saveProduct(randomProduct);
        String editedName = RandomProduct.getRandomProduct().getName();
        float editedPrice = new Random().nextFloat();
        int editedDiscount = RandomProduct.getRandomProduct().getDiscount();
        controller.updateProduct(new Product(
                id, editedName, editedPrice, editedDiscount));
        Product actualProduct = controller.findById(id);

        assertThat(actualProduct.getName()).isEqualTo(editedName);
        assertThat(actualProduct.getPrice()).isEqualTo(editedPrice);
        assertThat(actualProduct.getDiscount()).isEqualTo(editedDiscount);
        expectedName = editedName;
    }

    @Test
    public void testingTheMethodToDeleteByDiscount() {
        expectedName = randomProduct.getName();
        Long id = controller.saveProduct(randomProduct);
        Product product = controller.findById(id);
        assertThat(product.getName()).isEqualTo(expectedName);

        controller.deleteByDiscount(product.getDiscount());
        List<Product> products = controller.findAll();
        products.forEach(x -> assertThat(x.getName()).isNotEqualTo(expectedName));
    }

    @Test
    public void testingTheMethodToDeleteByPriceAndDiscount() {
        expectedName = randomProduct.getName();
        Long id = controller.saveProduct(randomProduct);
        Product product = controller.findById(id);
        assertThat(product.getName()).isEqualTo(expectedName);

        controller.deleteByPriceAndDiscount(product.getPrice(), product.getDiscount());
        List<Product> products = controller.findAll();
        products.forEach(x -> assertThat(x.getName()).isNotEqualTo(expectedName));
    }
}
