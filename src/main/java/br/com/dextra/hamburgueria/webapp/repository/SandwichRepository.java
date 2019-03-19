package br.com.dextra.hamburgueria.webapp.repository;

import br.com.dextra.hamburgueria.webapp.model.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Data Access Object used to retrieve data of a {@link Sandwich}.
 *
 * @author rafaelcustodio
 */
public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
}
