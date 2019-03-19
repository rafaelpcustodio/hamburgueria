package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.webapp.dto.ClientDTO;
import br.com.dextra.hamburgueria.webapp.model.Client;

import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link Client}.
 *
 * @author rafaelcustodio
 */
public interface ClientService {

    /**
     * Find all existing clients into the database.
     * @return The found clients.
     */
    List<ClientDTO> findAll();

    /**
     * Find a specific client by a identifier.
     * @param id The identifier of the client.
     * @return The found client.
     */
    ClientDTO findOne(final Long id);

    /**
     * Persist/Update a client into the database.
     * @param client The client to be persisted.
     * @return The persisted client.
     */
    ClientDTO save(final ClientDTO client);

    /**
     * Delete a certain client by their identifier.
     * @param id The identifier of the client.
     */
    void delete(final Long id);
}