package ru.dobraccoon.painmarket.products;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    public Product create(Product newProduct) {
        return new Product((long) 101, newProduct.getName(), newProduct.getPrice());
    }
}
