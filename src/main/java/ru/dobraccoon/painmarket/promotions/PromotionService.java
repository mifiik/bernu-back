package ru.dobraccoon.painmarket.promotions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dobraccoon.painmarket.products.Product;

import java.util.List;

@Service
@AllArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public Promotion create(Promotion newPromotion) {
        return promotionRepository.create(newPromotion);
    }

    public Promotion loadById(long promotionId) {
        return promotionRepository.loadById(promotionId);
    }

    public List<Promotion> loadAll() {
        return promotionRepository.loadAll();
    }

    public List<Promotion> loadAllActualPromotions() {
        return promotionRepository.loadAllActualPromotions();
    }

    public List<Product> loadAllProductsByPromotionId(long promotionId){
        return promotionRepository.loadAllProductsByPromotionId(promotionId);
    }

    public void update(Promotion promotion) {
        promotionRepository.update(promotion);
    }

    public void deleteById(long promotionId) {
        promotionRepository.deleteById(promotionId);
    }

    public void addListOfProductsToPromotion(ProductsToPromotionInput productsToPromotionInput) {
        promotionRepository.addListOfProductsToPromotion(productsToPromotionInput);
    }
}
