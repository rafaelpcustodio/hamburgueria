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

@Service("highAmountMeatPromotionCalculatorServiceImpl")
public class HighAmountMeatPromotionCalculatorServiceImpl implements PromotionCalculatorService {

    /**
     * Defines the minimum amount of meat to apply the discount.
     */
    private static final long MIN_AMOUNT_OF_MEAT = 3;

    @Autowired
    private PromotionService promotionService;

    @Override
    public double getDiscount(final List<IngredientDTO> ingredients) {

        double discount = 0.0;

        if(!ObjectUtils.isEmpty(ingredients)) {

            // Calculate the amount of meat hamburger defined as ingredient.
            final long meatHamburgerAmount = ingredients.stream()
                    .filter(ingredient -> IngredientAlias.MHB.equals(ingredient.getAlias()))
                    .count();

            // Sum all the ingredients prices.
            final double totalPrice = ingredients.stream().mapToDouble(IngredientDTO::getPrice).sum();

            // Verifies if the minimum amount of meat was achieved.
            if(meatHamburgerAmount >= MIN_AMOUNT_OF_MEAT) {
                final PromotionDTO promotion = this.promotionService.findByAlias(PromotionAlias.HAM);
                discount = totalPrice * promotion.getDiscount();
            }
        }

        return discount;
    }

    @Override
    public PromotionAlias getPromotionAlias() {
        return PromotionAlias.HAM;
    }
}