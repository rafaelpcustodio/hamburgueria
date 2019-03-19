package br.com.dextra.hamburgueria.webapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Class used to represent the information of all existing sandwiches for a specific combination of {@link IngredientDTO}.
 *
 * @author rafaelcustodio
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SandwichDTO {

    private Long id;

    @NotEmpty(message = "O nome do lanche é obrigatório.")
    private String name;

    @NotEmpty(message = "Os ingredientes do lanche são obrigatórios.")
    private List<IngredientDTO> ingredients;

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

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
