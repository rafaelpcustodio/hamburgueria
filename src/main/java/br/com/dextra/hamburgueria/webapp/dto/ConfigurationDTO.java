package br.com.dextra.hamburgueria.webapp.dto;

import br.com.dextra.hamburgueria.webapp.enumerable.ConfigurationCode;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Class used to represent the information of all existing configuration variables stored on the database.
 *
 * @author rafaelcustodio
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationDTO {

    private Long id;

    private ConfigurationCode code;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConfigurationCode getCode() {
        return code;
    }

    public void setCode(ConfigurationCode code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
