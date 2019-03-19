package br.com.dextra.hamburgueria.webapp.repository;

import br.com.dextra.hamburgueria.webapp.enumerable.PromotionAlias;
import br.com.dextra.hamburgueria.webapp.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * The Data Access Object used to retrieve data of a {@link Promotion}.
 *
 * @author rafaelcustodio
 */
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    /**
     * Find by a specific alias.
     * @param alias The alias to be used by the search.
     * @return The found common by the alias.
     */
    Promotion findByAlias(@Param("alias") final PromotionAlias alias);
}