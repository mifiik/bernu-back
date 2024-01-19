package ru.avsamoylov.painmarket.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product create(@RequestBody Product product) {
        return productRepository.create(product);
    }
}
