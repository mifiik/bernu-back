package ru.dobraccoon.painmarket.products;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product newProduct) {
        return productRepository.create(newProduct);
    }

    public Product loadById(long productId) {
        return productRepository.loadById(productId);
    }
}
