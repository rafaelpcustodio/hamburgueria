package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.webapp.dto.SandwichDTO;

import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Sandwich}.
 *
 * @author rafaelcustodio
 */
public interface SandwichService {
    
    /**
     * Find all existing sandwiches into the database.
     * @return The found sandwiches.
     */
    List<SandwichDTO> findAll();

    /**
     * Find a specific sandwich by a identifier.
     * @param id The identifier of the sandwich.
     * @return The found sandwich.
     */
    SandwichDTO findOne(final Long id);
}
