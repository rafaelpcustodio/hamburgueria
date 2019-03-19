package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import br.com.dextra.hamburgueria.webapp.enumerable.PromotionAlias;
import br.com.dextra.hamburgueria.webapp.model.Request;

import java.util.List;

/**
 * Represents a service responsible for performing discounts for an {@link Request}
 *
 * @author rafaelcustodio
 */
public interface PromotionCalculatorService {

    /**
     * Performs the discount based on the amount of ingredients and their prices.
     * @param ingredients All the ingredients to be used for the calculation.
     * @return The list of all ingredients.
     */
    double getDiscount(List<IngredientDTO> ingredients);

    /**
     * Get the representation of the alias of a common that the calculator is associated to.
     * @return The common alias.
     */
    PromotionAlias getPromotionAlias();
}