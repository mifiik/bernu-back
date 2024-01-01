package ru.dobraccoon.painmarket.products;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product newProduct) {
        return productService.create(newProduct);
    }

    @GetMapping("/{productId}")
    public Product loadById(@PathVariable long productId) {
        return productService.loadById(productId);
    }
}
