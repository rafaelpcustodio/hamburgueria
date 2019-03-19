package br.com.dextra.hamburgueria.webapp.mapper;

import br.com.dextra.hamburgueria.webapp.dto.ConfigurationDTO;
import br.com.dextra.hamburgueria.webapp.model.Configuration;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible for handling the mapping for a {@link Configuration}.
 * 
 * @author rafaelcustodio
 */
public class ConfigurationMapper {
    
    private ConfigurationMapper() {}

    /**
     * Convert a entity into a data transfer object.
     * @param entity The entity to be converted.
     * @return The converted entity.
     */
    public static ConfigurationDTO entityToDTO(Configuration entity) {
        if(entity != null) {
            ConfigurationDTO dto = new ConfigurationDTO();
            dto.setId(entity.getId());
            dto.setCode(entity.getCode());
            dto.setValue(entity.getValue());
            return dto;
        }
        return null;
    }

    /**
     * Convert a list of entities into a list of data transfer objects.
     * @param entities The list of entities to be converted.
     * @return The converted list of entities.
     */
    public static List<ConfigurationDTO> entityToDTO(List<Configuration> entities) {
        if(!ObjectUtils.isEmpty(entities)) {
            return entities.stream().map(ConfigurationMapper::entityToDTO).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Convert a data transfer object into an entity.
     * @param dto The data transfer object to be converted.
     * @return The converted data transfer object.
     */
    public static Configuration dtoToEntity(ConfigurationDTO dto) {
        if(dto != null) {
            Configuration entity = new Configuration();
            entity.setId(dto.getId());
            entity.setCode(dto.getCode());
            entity.setValue(dto.getValue());
            return entity;
        }
        return null;
    }

    /**
     * Convert a list of data transfer object into a list of entities.
     * @param dtos The list of data transfer object to be converted.
     * @return The converted list of data transfer object.
     */
    public static List<Configuration> dtoToEntity(List<ConfigurationDTO> dtos) {
        if(!ObjectUtils.isEmpty(dtos)) {
            return dtos.stream().map(ConfigurationMapper::dtoToEntity).collect(Collectors.toList());
        }
        return null;
    }
}