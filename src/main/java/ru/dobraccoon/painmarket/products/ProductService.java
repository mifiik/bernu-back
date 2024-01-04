package ru.dobraccoon.painmarket.products;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product newProduct) {
        return productRepository.create(newProduct);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void deleteById(long productId) {
        productRepository.deleteById(productId);
    }

    public void deleteByPriceAndDiscount(float price, int discount) {
        productRepository.deleteByPriceAndDiscount(price, discount);
    }

    public Product loadById(long productId) {
        return productRepository.loadById(productId);
    }

    public List<Product> loadAll() {
        return productRepository.loadAll();
    }

    public List<Product> loadByDiscount(int discount) {

        return productRepository.loadByDiscount(discount);
    }
}
