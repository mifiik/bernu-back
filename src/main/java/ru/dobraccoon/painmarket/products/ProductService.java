package ru.dobraccoon.painmarket.products;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product newProduct) {
        productRepository.create(newProduct);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void deleteByPrimaryPrice(float primaryPrice) {
        productRepository.deleteByPrimaryPrice(primaryPrice);
    }

    public void deleteById(long productId) {
        productRepository.deleteById(productId);
    }

    public void deleteByDescription(String description) {
        productRepository.deleteByDescription(description);
    }

    public Product loadById(long productId) {
        return productRepository.loadById(productId);
    }

    public List<Product> loadAll() {
        return productRepository.loadAll();
    }


    public List<Product> loadByCurrentPrice(float currentPrice) {

        return productRepository.loadByCurrentPrice(currentPrice);
    }

    public List<Product> loadByDiscount(int discount) {
        return productRepository.loadByDiscount(discount);
    }

}
