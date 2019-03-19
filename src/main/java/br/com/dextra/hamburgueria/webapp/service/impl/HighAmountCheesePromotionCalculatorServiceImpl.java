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

@Service("highAmountCheesePromotionCalculatorServiceImpl")
public class HighAmountCheesePromotionCalculatorServiceImpl implements PromotionCalculatorService {

    /**
     * Defines the minimum amount of cheese to apply the discount.
     */
    private static final long MIN_AMOUNT_OF_CHEESE = 3;

    @Autowired
    private PromotionService promotionService;

    @Override
    public double getDiscount(final List<IngredientDTO> ingredients) {

        double discount = 0.0;

        if(!ObjectUtils.isEmpty(ingredients)) {

            // Calculate the amount of cheese defined as ingredient.
            final long cheeseHamburgerAmount = ingredients.stream()
                    .filter(ingredient -> IngredientAlias.CHE.equals(ingredient.getAlias()))
                    .count();

            // Sum all the ingredients prices.
            final double totalPrice = ingredients.stream().mapToDouble(IngredientDTO::getPrice).sum();

            // Verifies if the minimum amount of cheese was achieved.
            if(cheeseHamburgerAmount >= MIN_AMOUNT_OF_CHEESE) {
                final PromotionDTO promotion = this.promotionService.findByAlias(PromotionAlias.AMC);
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