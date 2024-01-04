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

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping("{productId}")
    public void deleteById(@PathVariable long productId) {
        productService.deleteById(productId);
    }

    @DeleteMapping("{price}/{discount}")
    public void deleteByPriceAndDiscount(@PathVariable float price, @PathVariable int discount) {
        productService.deleteByPriceAndDiscount(price, discount);
    }

    @DeleteMapping("/delete-by-name/{name}")
    public void deleteByName(@PathVariable String name) {
        productService.deleteByName(name);
    }

    @DeleteMapping("/delete-by-discount/{discount}")
    public void deleteByDiscount(@PathVariable int discount) {
        productService.deleteByDiscount(discount);
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
