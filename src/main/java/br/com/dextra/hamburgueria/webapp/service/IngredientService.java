package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;

import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Ingredient}.
 *
 * @author rafaelcustodio
 */
public interface IngredientService {

    /**
     * Find all existing ingredients into the database.
     * @return The found ingredients.
     */
    List<IngredientDTO> findAll();

    /**
     * Find a specific ingredient by a identifier.
     * @param id The identifier of the ingredient.
     * @return The found ingredient.
     */
    IngredientDTO findOne(final Long id);
}
