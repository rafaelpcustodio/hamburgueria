package br.com.dextra.hamburgueria.webapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Class used to represent the information of a client stored on the database.
 *
 * @author rafaelcustodio
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private Long id;

    @NotEmpty(message = "O nome do cliente é obrigatório.")
    private String name;

    @NotNull(message = "O numero fiscal do cliente é obrigatório.")
    private Long fiscalNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(Long fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }
}
