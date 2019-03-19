package br.com.dextra.hamburgueria.webapp.repository;

import br.com.dextra.hamburgueria.webapp.enumerable.ConfigurationCode;
import br.com.dextra.hamburgueria.webapp.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * The Data Access Object used to retrieve data of a {@link Configuration}.
 *
 * @author rafaelcustodio
 */
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

    /**
     * Find a certain configuration by its code.
     * @param code The code of the configuration.
     * @return The found configuration.
     */
    Configuration findByCode(@Param("name") ConfigurationCode code);
}
