package br.com.dextra.hamburgueria.webapp.repository;

import br.com.dextra.hamburgueria.webapp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Data Access Object used to retrieve data of a {@link Request}.
 *
 * @author rafaelcustodio
 */
public interface RequestRepository extends JpaRepository<Request, Long> {
}
