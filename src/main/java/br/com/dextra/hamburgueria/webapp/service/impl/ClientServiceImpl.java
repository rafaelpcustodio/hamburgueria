package br.com.dextra.hamburgueria.webapp.service.impl;

import br.com.dextra.hamburgueria.webapp.dto.ClientDTO;
import br.com.dextra.hamburgueria.webapp.mapper.ClientMapper;
import br.com.dextra.hamburgueria.webapp.model.Client;
import br.com.dextra.hamburgueria.webapp.repository.ClientRepository;
import br.com.dextra.hamburgueria.webapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link Client}.
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> findAll() {
        return ClientMapper.entityToDTO(this.clientRepository.findAll());
    }

    @Override
    public ClientDTO findOne(final Long id) {
        return ClientMapper.entityToDTO(this.clientRepository.findOne(id));
    }

    @Override
    public ClientDTO save(final ClientDTO client) {
        final Client clientToPersist = ClientMapper.dtoToEntity(client);
        return ClientMapper.entityToDTO(this.clientRepository.save(clientToPersist));
    }

    @Override
    public void delete(final Long id) {
        this.clientRepository.delete(id);
    }
}