package ru.avsamoylov.painmarket.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.Random;

@Repository
@AllArgsConstructor
public class ProductRepository {

    public Product create(Product product) {
        return new Product(
                new Random().nextLong(), product.getName(), product.getPrice(), product.getDiscount());
    }
}
