package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.webapp.dto.PromotionDTO;
import br.com.dextra.hamburgueria.webapp.enumerable.PromotionAlias;

import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Promotion}.
 *
 * @author rafaelcustodio
 */
public interface PromotionService {

    /**
     * Find all existing promotions into the database.
     * @return The found promotions.
     */
    List<PromotionDTO> findAll();

    /**
     * Find a specific common by a identifier.
     * @param id The identifier of the common.
     * @return The found common.
     */
    PromotionDTO findOne(Long id);

    /**
     * Find by a specific alias.
     * @param alias The alias to be used by the search.
     * @return The found common by the alias.
     */
    PromotionDTO findByAlias(PromotionAlias alias);
}