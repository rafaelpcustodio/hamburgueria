package br.com.dextra.hamburgueria.webapp.service.impl;

import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import br.com.dextra.hamburgueria.webapp.mapper.IngredientMapper;
import br.com.dextra.hamburgueria.webapp.repository.IngredientRepository;
import br.com.dextra.hamburgueria.webapp.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link br.com.dextra.hamburgueria.webapp.model.Ingredient}.
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class IngredientServiceImpl implements IngredientService  {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<IngredientDTO> findAll() {
        return IngredientMapper.entityToDTO(this.ingredientRepository.findAll());
    }

    @Override
    public IngredientDTO findOne(final Long id) {
        return IngredientMapper.entityToDTO(this.ingredientRepository.findOne(id));
    }
}
