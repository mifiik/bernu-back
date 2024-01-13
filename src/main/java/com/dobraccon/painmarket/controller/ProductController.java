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
}
