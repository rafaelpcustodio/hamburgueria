package br.com.dextra.hamburgueria.webapp.mapper;

import br.com.dextra.hamburgueria.webapp.dto.RequestDTO;
import br.com.dextra.hamburgueria.webapp.model.Request;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible for handling the mapping for a {@link Request}.
 * 
 * @author rafaelcustodio
 */
public class RequestMapper {

    private RequestMapper() {}

    /**
     * Convert a entity into a data transfer object.
     * @param entity The entity to be converted.
     * @return The converted entity.
     */
    public static RequestDTO entityToDTO(Request entity) {
        if(entity != null) {
            RequestDTO dto = new RequestDTO();
            dto.setId(entity.getId());
            dto.setIngredients(IngredientMapper.entityToDTO(entity.getIngredients()));
            dto.setTotal(entity.getTotal());
            return dto;
        }
        return null;
    }

    /**
     * Convert a list of entities into a list of data transfer objects.
     * @param entities The list of entities to be converted.
     * @return The converted list of entities.
     */
    public static List<RequestDTO> entityToDTO(List<Request> entities) {
        if(!ObjectUtils.isEmpty(entities)) {
            return entities.stream().map(RequestMapper::entityToDTO).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Convert a data transfer object into an entity.
     * @param dto The data transfer object to be converted.
     * @return The converted data transfer object.
     */
    public static Request dtoToEntity(RequestDTO dto) {
        if(dto != null) {
            Request entity = new Request();
            entity.setId(dto.getId());
            entity.setIngredients(IngredientMapper.dtoToEntity(dto.getIngredients()));
            entity.setTotal(dto.getTotal());
            return entity;
        }
        return null;
    }

    /**
     * Convert a list of data transfer object into a list of entities.
     * @param dtos The list of data transfer object to be converted.
     * @return The converted list of data transfer object.
     */
    public static List<Request> dtoToEntity(List<RequestDTO> dtos) {
        if(!ObjectUtils.isEmpty(dtos)) {
            return dtos.stream().map(RequestMapper::dtoToEntity).collect(Collectors.toList());
        }
        return null;
    }
}