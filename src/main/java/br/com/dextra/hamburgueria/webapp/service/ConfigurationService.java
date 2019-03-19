package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.webapp.dto.ConfigurationDTO;
import br.com.dextra.hamburgueria.webapp.enumerable.ConfigurationCode;

import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Configuration}.
 *
 * @author rafaelcustodio
 */
public interface ConfigurationService {

    /**
     * Find all existing configuration into the database.
     * @return The found configuration.
     */
    List<ConfigurationDTO> findAll();

    /**
     * Find a specific configuration by a identifier.
     * @param id The identifier of the configuration.
     * @return The found configuration.
     */
    ConfigurationDTO findOne(final Long id);

    /**
     * Find a certain configuration by its code.
     * @param code The code of the configuration.
     * @return The found configuration.
     */
    ConfigurationDTO findByCode(ConfigurationCode code);
}