package ru.dobraccoon.painmarket.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("load-all")
    public List<Product> loadAll() {
        return productService.loadAll();
    }

    @GetMapping("/load-by-discount/{discount}")
    public List<Product> loadByDiscount(@PathVariable int discount) {

        return productService.loadByDiscount(discount);
    }
}
