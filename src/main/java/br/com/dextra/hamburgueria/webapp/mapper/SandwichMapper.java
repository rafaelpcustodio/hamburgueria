package br.com.dextra.hamburgueria.webapp.mapper;

import br.com.dextra.hamburgueria.webapp.dto.SandwichDTO;
import br.com.dextra.hamburgueria.webapp.model.Sandwich;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible for handling the mapping for a {@link Sandwich}.
 * 
 * @author rafaelcustodio
 */
public class SandwichMapper {
    
    private SandwichMapper() {}

    /**
     * Convert a entity into a data transfer object.
     * @param entity The entity to be converted.
     * @return The converted entity.
     */
    public static SandwichDTO entityToDTO(Sandwich entity) {
        if(entity != null) {
            SandwichDTO dto = new SandwichDTO();
            dto.setIngredients(IngredientMapper.entityToDTO(entity.getIngredients()));
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            return dto;
        }
        return null;
    }

    /**
     * Convert a list of entities into a list of data transfer objects.
     * @param entities The list of entities to be converted.
     * @return The converted list of entities.
     */
    public static List<SandwichDTO> entityToDTO(List<Sandwich> entities) {
        if(!ObjectUtils.isEmpty(entities)) {
            return entities.stream().map(SandwichMapper::entityToDTO).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Convert a data transfer object into an entity.
     * @param dto The data transfer object to be converted.
     * @return The converted data transfer object.
     */
    public static Sandwich dtoToEntity(SandwichDTO dto) {
        if(dto != null) {
            Sandwich entity = new Sandwich();
            entity.setIngredients(IngredientMapper.dtoToEntity(dto.getIngredients()));
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            return entity;
        }
        return null;
    }

    /**
     * Convert a list of data transfer object into a list of entities.
     * @param dtos The list of data transfer object to be converted.
     * @return The converted list of data transfer object.
     */
    public static List<Sandwich> dtoToEntity(List<SandwichDTO> dtos) {
        if(!ObjectUtils.isEmpty(dtos)) {
            return dtos.stream().map(SandwichMapper::dtoToEntity).collect(Collectors.toList());
        }
        return null;
    }
}