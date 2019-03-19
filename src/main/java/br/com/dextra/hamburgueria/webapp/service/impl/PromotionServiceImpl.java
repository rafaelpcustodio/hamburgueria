package br.com.dextra.hamburgueria.webapp.service.impl;

import br.com.dextra.hamburgueria.webapp.dto.PromotionDTO;
import br.com.dextra.hamburgueria.webapp.enumerable.PromotionAlias;
import br.com.dextra.hamburgueria.webapp.mapper.PromotionMapper;
import br.com.dextra.hamburgueria.webapp.repository.PromotionRepository;
import br.com.dextra.hamburgueria.webapp.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Promotion}.
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {
    
    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<PromotionDTO> findAll() {
        return PromotionMapper.entityToDTO(this.promotionRepository.findAll());
    }

    @Override
    public PromotionDTO findOne(final Long id) {
        return PromotionMapper.entityToDTO(this.promotionRepository.findOne(id));
    }

    @Override
    public PromotionDTO findByAlias(final PromotionAlias alias) {
        return PromotionMapper.entityToDTO(this.promotionRepository.findByAlias(alias));
    }
}