package br.com.dextra.hamburgueria.webapp.mapper;

import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import br.com.dextra.hamburgueria.webapp.model.Ingredient;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible for handling the mapping for a {@link Ingredient}.
 * 
 * @author rafaelcustodio
 */
public class IngredientMapper {
    
    private IngredientMapper() {}

    /**
     * Convert a entity into a data transfer object.
     * @param entity The entity to be converted.
     * @return The converted entity.
     */
    public static IngredientDTO entityToDTO(Ingredient entity) {
        if(entity != null) {
            IngredientDTO dto = new IngredientDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setAlias(entity.getAlias());
            dto.setPrice(entity.getPrice());
            return dto;
        }
        return null;
    }

    /**
     * Convert a list of entities into a list of data transfer objects.
     * @param entities The list of entities to be converted.
     * @return The converted list of entities.
     */
    public static List<IngredientDTO> entityToDTO(List<Ingredient> entities) {
        if(!ObjectUtils.isEmpty(entities)) {
            return entities.stream().map(IngredientMapper::entityToDTO).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Convert a data transfer object into an entity.
     * @param dto The data transfer object to be converted.
     * @return The converted data transfer object.
     */
    public static Ingredient dtoToEntity(IngredientDTO dto) {
        if(dto != null) {
            Ingredient entity = new Ingredient();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setAlias(dto.getAlias());
            entity.setPrice(dto.getPrice());
            return entity;
        }
        return null;
    }

    /**
     * Convert a list of data transfer object into a list of entities.
     * @param dtos The list of data transfer object to be converted.
     * @return The converted list of data transfer object.
     */
    public static List<Ingredient> dtoToEntity(List<IngredientDTO> dtos) {
        if(!ObjectUtils.isEmpty(dtos)) {
            return dtos.stream().map(IngredientMapper::dtoToEntity).collect(Collectors.toList());
        }
        return null;
    }
}