package br.com.dextra.hamburgueria.webapp.service.impl;

import br.com.dextra.hamburgueria.webapp.dto.ConfigurationDTO;
import br.com.dextra.hamburgueria.webapp.enumerable.ConfigurationCode;
import br.com.dextra.hamburgueria.webapp.mapper.ConfigurationMapper;
import br.com.dextra.hamburgueria.webapp.repository.ConfigurationRepository;
import br.com.dextra.hamburgueria.webapp.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Configuration}.
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public List<ConfigurationDTO> findAll() {
        return ConfigurationMapper.entityToDTO(this.configurationRepository.findAll());
    }

    @Override
    public ConfigurationDTO findOne(final Long id) {
        return ConfigurationMapper.entityToDTO(this.configurationRepository.findOne(id));
    }

    @Override
    public ConfigurationDTO findByCode(final ConfigurationCode code) {
        return ConfigurationMapper.entityToDTO(this.configurationRepository.findByCode(code));
    }
}