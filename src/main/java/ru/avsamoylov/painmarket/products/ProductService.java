package ru.avsamoylov.painmarket.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product create(@RequestBody Product product) {
        return productRepository.create(product);
    }
}
