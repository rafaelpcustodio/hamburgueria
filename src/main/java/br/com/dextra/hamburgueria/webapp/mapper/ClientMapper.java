package br.com.dextra.hamburgueria.webapp.mapper;

import br.com.dextra.hamburgueria.webapp.dto.ClientDTO;
import br.com.dextra.hamburgueria.webapp.model.Client;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class responsible for handling the mapping for a {@link Client}.
 *
 * @author rafaelcustodio
 */
public class ClientMapper {

    private ClientMapper() {}

    /**
     * Convert a entity into a data transfer object.
     * @param entity The entity to be converted.
     * @return The converted entity.
     */
    public static ClientDTO entityToDTO(Client entity) {
        if(entity != null) {
            ClientDTO dto = new ClientDTO();
            dto.setFiscalNumber(entity.getFiscalNumber());
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
    public static List<ClientDTO> entityToDTO(List<Client> entities) {
        if(!ObjectUtils.isEmpty(entities)) {
            return entities.stream().map(ClientMapper::entityToDTO).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Convert a data transfer object into an entity.
     * @param dto The data transfer object to be converted.
     * @return The converted data transfer object.
     */
    public static Client dtoToEntity(ClientDTO dto) {
        if(dto != null) {
            Client entity = new Client();
            entity.setFiscalNumber(dto.getFiscalNumber());
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
    public static List<Client> dtoToEntity(List<ClientDTO> dtos) {
        if(!ObjectUtils.isEmpty(dtos)) {
            return dtos.stream().map(ClientMapper::dtoToEntity).collect(Collectors.toList());
        }
        return null;
    }
}