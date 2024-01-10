package ru.dobraccoon.painmarket.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product newProduct) {
        return productService.create(newProduct);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable long productId) {
        productService.deleteById(productId);
    }

    @DeleteMapping("/{primaryPrice}")
    public void deleteByPrimaryPrice(@PathVariable float primaryPrice) {
        productService.deleteByPrimaryPrice(primaryPrice);
    }

    @DeleteMapping("/delete-by-description/{description}")
    public void deleteByDescription(@PathVariable String description) {
        productService.deleteByDescription(description);
    }

    @GetMapping("/{productId}")
    public Product loadById(@PathVariable long productId) {
        return productService.loadById(productId);
    }

    @GetMapping("load-all")
    public List<Product> loadAll() {
        return productService.loadAll();
    }

    @GetMapping("/load-by-Current-price/{currentPrice}")
    public List<Product> loadByCurrentPrice(@PathVariable float currentPrice) {

        return productService.loadByCurrentPrice(currentPrice);
    }

    @GetMapping("/load-by-discount/{discount}")
    public List<Product> loadByDiscount(@PathVariable int discount) {
        return productService.loadByDiscount(discount);
    }

}
