package br.com.dextra.hamburgueria.webapp.dto;

import br.com.dextra.hamburgueria.webapp.enumerable.IngredientAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class used to represent the information of all existing ingredients stored on the database.
 *
 * @author rafaelcustodio
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IngredientDTO {

    private Long id;

    @NotEmpty(message = "O nome do ingrediente é obrigatório.")
    private String name;

    @NotEmpty(message = "A sigla do ingrediente é obrigatóra.")
    @Column(name = "ALIAS")
    private IngredientAlias alias;

    @NotNull(message = "O preço do ingrediente é obrigatório.")
    private Double price;

    private List<SandwichDTO> sandwiches;

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

    public IngredientAlias getAlias() {
        return alias;
    }

    public void setAlias(IngredientAlias alias) {
        this.alias = alias;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<SandwichDTO> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<SandwichDTO> sandwiches) {
        this.sandwiches = sandwiches;
    }
}
