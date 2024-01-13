package com.dobraccon.painmarket.service;

import com.dobraccon.painmarket.model.Product;
import com.dobraccon.painmarket.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public void saveProduct(Product product) {
        repository.saveProduct(product);
    }

    public Product findByProductId(long id) {
        return repository.findByProductId(id);
    }

    public List<Product> findAllProducts() {
        return repository.findAllProducts();
    }

    public List<Product> findProductsByDiscount(int discount) {
        return repository.findProductsByDiscount(discount);
    }
}
