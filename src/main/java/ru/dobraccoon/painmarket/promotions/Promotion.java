package ru.dobraccoon.painmarket.promotions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Promotion {
   @Setter
   private Long id;
   private String imageUrl;
   private String promotionName;
   private String promotionDescription;
   private boolean isPromotionActual;
}
