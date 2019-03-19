package br.com.dextra.hamburgueria.webapp.mapper;

import br.com.dextra.hamburgueria.webapp.dto.PromotionDTO;
import br.com.dextra.hamburgueria.webapp.model.Promotion;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible for handling the mapping for a {@link Promotion}.
 * 
 * @author rafaelcustodio
 */
public class PromotionMapper {
    
    private PromotionMapper() {}

    /**
     * Convert a entity into a data transfer object.
     * @param entity The entity to be converted.
     * @return The converted entity.
     */
    public static PromotionDTO entityToDTO(Promotion entity) {
        if(entity != null) {
            PromotionDTO dto = new PromotionDTO();
            dto.setDiscount(entity.getDiscount());
            dto.setId(entity.getId());
            dto.setAlias(entity.getAlias());
            return dto;
        }
        return null;
    }

    /**
     * Convert a list of entities into a list of data transfer objects.
     * @param entities The list of entities to be converted.
     * @return The converted list of entities.
     */
    public static List<PromotionDTO> entityToDTO(List<Promotion> entities) {
        if(!ObjectUtils.isEmpty(entities)) {
            return entities.stream().map(PromotionMapper::entityToDTO).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Convert a data transfer object into an entity.
     * @param dto The data transfer object to be converted.
     * @return The converted data transfer object.
     */
    public static Promotion dtoToEntity(PromotionDTO dto) {
        if(dto != null) {
            Promotion entity = new Promotion();
            entity.setDiscount(dto.getDiscount());
            entity.setId(dto.getId());
            entity.setAlias(dto.getAlias());
            return entity;
        }
        return null;
    }

    /**
     * Convert a list of data transfer object into a list of entities.
     * @param dtos The list of data transfer object to be converted.
     * @return The converted list of data transfer object.
     */
    public static List<Promotion> dtoToEntity(List<PromotionDTO> dtos) {
        if(!ObjectUtils.isEmpty(dtos)) {
            return dtos.stream().map(PromotionMapper::dtoToEntity).collect(Collectors.toList());
        }
        return null;
    }
}