package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.webapp.dto.RequestDTO;
import br.com.dextra.hamburgueria.webapp.model.Request;

import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link Request}.
 *
 * @author rafaelcustodio
 */
public interface RequestService {

    /**
     * Find all existing requests into the database.
     * @return The found requests.
     */
    List<RequestDTO> findAll();

    /**
     * Find a specific request by a identifier.
     * @param id The identifier of the request.
     * @return The found request.
     */
    RequestDTO findOne(final Long id);

    /**
     * Persist/Update a request into the database.
     * @param request The request to be persisted.
     * @return The persisted request.
     */
    RequestDTO save(final RequestDTO request);
    /**
     * Delete a certain request by their identifier.
     * @param id The identifier of the request.
     */
    void delete(final Long id);
}