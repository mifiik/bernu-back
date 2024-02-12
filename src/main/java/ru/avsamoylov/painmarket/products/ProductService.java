package ru.avsamoylov.painmarket.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Long create(@RequestBody Product product) {
        return productRepository.saveProduct(product);
    }

    public Product findByProductId(long id) {
        return productRepository.findByProductId(id);
    }
}
