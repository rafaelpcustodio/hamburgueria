package br.com.dextra.hamburgueria.webapp.service.impl;

import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import br.com.dextra.hamburgueria.webapp.dto.PromotionDTO;
import br.com.dextra.hamburgueria.webapp.enumerable.IngredientAlias;
import br.com.dextra.hamburgueria.webapp.enumerable.PromotionAlias;
import br.com.dextra.hamburgueria.webapp.service.PromotionCalculatorService;
import br.com.dextra.hamburgueria.webapp.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service("lightPromotionCalculatorServiceImpl")
public class LightPromotionCalculatorServiceImpl implements PromotionCalculatorService {

    /**
     * Defines the minimum amount of lettuce to apply the discount.
     */
    private static final long MIN_AMOUNT_OF_LETTUCE = 1;

    /**
     * Defines the minimum amount of bacon to apply the discount.
     */
    private static final long MAX_AMOUNT_OF_BACON = 0;

    @Autowired
    private PromotionService promotionService;

    @Override
    public double getDiscount(final List<IngredientDTO> ingredients) {

        double discount = 0.0;

        if(!ObjectUtils.isEmpty(ingredients)) {

            // Calculate the amount of lettuce defined as ingredient.
            final long lettuceAmount = ingredients.stream()
                    .filter(ingredient -> IngredientAlias.LTC.equals(ingredient.getAlias()))
                    .count();

            // Calculate the amount of bacon defined as ingredient.
            final long baconAmount = ingredients.stream()
                    .filter(ingredient -> IngredientAlias.BCN.equals(ingredient.getAlias()))
                    .count();

            // Sum all the ingredients prices.
            final double totalPrice = ingredients.stream().mapToDouble(IngredientDTO::getPrice).sum();

            // Verifies if the amount of lettuce is higher than 0 and there is no bacon.
            if(lettuceAmount >= MIN_AMOUNT_OF_LETTUCE && baconAmount == MAX_AMOUNT_OF_BACON) {
                final PromotionDTO promotion = this.promotionService.findByAlias(PromotionAlias.LGT);
                discount = totalPrice * promotion.getDiscount();
            }
        }

        return discount;
    }

    @Override
    public PromotionAlias getPromotionAlias() {
        return PromotionAlias.LGT;
    }
}