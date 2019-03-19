package br.com.dextra.hamburgueria.webapp.service.impl;

import br.com.dextra.hamburgueria.webapp.dto.SandwichDTO;
import br.com.dextra.hamburgueria.webapp.mapper.SandwichMapper;
import br.com.dextra.hamburgueria.webapp.repository.SandwichRepository;
import br.com.dextra.hamburgueria.webapp.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Sandwich}.
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class SandwichServiceImpl implements SandwichService {

    @Autowired
    private SandwichRepository sandwichRepository;

    @Override
    public List<SandwichDTO> findAll() {
        return SandwichMapper.entityToDTO(this.sandwichRepository.findAll());
    }

    @Override
    public SandwichDTO findOne(final Long id) {
        return SandwichMapper.entityToDTO(this.sandwichRepository.findOne(id));
    }
}
