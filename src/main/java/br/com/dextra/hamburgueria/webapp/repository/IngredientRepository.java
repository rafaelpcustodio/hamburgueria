package br.com.dextra.hamburgueria.webapp.repository;

import br.com.dextra.hamburgueria.webapp.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Data Access Object used to retrieve data of a {@link Ingredient}.
 *
 * @author rafaelcustodio
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
