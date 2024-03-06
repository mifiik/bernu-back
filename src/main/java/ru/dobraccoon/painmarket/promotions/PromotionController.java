package ru.dobraccoon.painmarket.promotions;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dobraccoon.painmarket.products.Product;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @PostMapping
    public Promotion create(@RequestBody Promotion newPromotion) {
        return promotionService.create(newPromotion);
    }

    @GetMapping("{promotionId}")
    public Promotion loadById(@PathVariable long promotionId) {
        return promotionService.loadById(promotionId);
    }

    @GetMapping("/load-all")
    public List<Promotion> loadAll() {
        return promotionService.loadAll();
    }

    @GetMapping("/load-all-actual-promotions")
    public List<Promotion> loadAllActualPromotions() {
        return promotionService.loadAllActualPromotions();
    }

    @GetMapping("/load-all-products-by-promotionId{promotionId}")
    public List<Product> loadAllProductsByPromotionId(@PathVariable long promotionId) {
        return promotionService.loadAllProductsByPromotionId(promotionId);
    }

    @PutMapping
    public void update(@RequestBody Promotion promotion) {
        promotionService.update(promotion);
    }

    @DeleteMapping("{promotionId}")
    public void deleteById(@PathVariable long promotionId) {
        promotionService.deleteById(promotionId);
    }

    @PostMapping("/add-list-of-products-to-promotion")
    public void addListOfProductsToPromotion(@RequestBody ProductsToPromotionInput productsToPromotionInput) {
        promotionService.addListOfProductsToPromotion(productsToPromotionInput);
    }
}
