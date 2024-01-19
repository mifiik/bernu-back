package com.dobraccon.painmarket.products;

import com.dobraccon.painmarket.products.Product;
import com.dobraccon.painmarket.products.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public Long saveProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product findByProductId(@PathVariable long id) {
        return service.findByProductId(id);
    }

    @GetMapping("/load-all")
    public List<Product> findAllProducts() {
        return service.findAllProducts();
    }

    @GetMapping("/find-by-discount/{discount}")
    public List<Product> findProductsByDiscount(@PathVariable int discount) {
        return service.findProductsByDiscount(discount);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/delete-by-discount/{discount}")
    public void deleteProductByDiscount(@PathVariable int discount) {
        service.deleteProductByDiscount(discount);
    }

    @DeleteMapping("/delete-by-name/{name}")
    public void deleteProductByName(@PathVariable String name) {
        service.deleteProductByName(name);
    }

    @DeleteMapping("/delete-by-price/{price}/by-discount/{discount}")
    public void deleteProductByPriceAndDiscount(@PathVariable float price, @PathVariable int discount) {
        service.deleteProductByPriceAndDiscount(price, discount);
    }
}