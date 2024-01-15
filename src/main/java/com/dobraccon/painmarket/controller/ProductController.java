package com.dobraccon.painmarket.controller;

import com.dobraccon.painmarket.model.Product;
import com.dobraccon.painmarket.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product findByProductId(@PathVariable long id) {
        return service.findByProductId(id);
    }

    @GetMapping("/load-all")
    public List<Product> findAllProducts() {
        return service.findAllProducts();
    }

    @GetMapping("/load-all/{discount}")
    public List<Product> findProductsByDiscount(@PathVariable int discount) {
        return service.findProductsByDiscount(discount);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/delete-by-discount/{discount}")
    public void deleteProduct(@PathVariable int discount) {
        service.deleteProduct(discount);
    }

    @DeleteMapping("/delete-by-name/{name}")
    public void deleteProduct(@PathVariable String name) {
        service.deleteProduct(name);
    }

    @DeleteMapping("/delete-by-price/{price}/by-discount/{discount}")
    public void deleteProduct(@PathVariable float price, @PathVariable int discount) {
        service.deleteProduct(price, discount);
    }
}
