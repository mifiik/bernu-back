package com.dobraccon.painmarket.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Long saveProduct(Product product) {
        return repository.saveProduct(product);
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

    public void updateProduct(Product product) {
        repository.updateProduct(product);
    }

    public void deleteProductByDiscount(int discount) {
        repository.deleteProductByDiscount(discount);
    }

    public void deleteProductByName(String name) {
        repository.deleteProductByName(name);
    }

    public void deleteProductByPriceAndDiscount(float price, int discount) {
        repository.deleteProductByPriceAndDiscount(price, discount);
    }
}
