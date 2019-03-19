package br.com.dextra.hamburgueria.webapp.repository;

import br.com.dextra.hamburgueria.webapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Data Access Object used to retrieve data of a {@link Client}.
 *
 * @author rafaelcustodio
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
