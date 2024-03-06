package ru.dobraccoon.painmarket.promotions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class ProductsToPromotionInput {
   private long promotionId;
   private List<Long> productsIds;
}