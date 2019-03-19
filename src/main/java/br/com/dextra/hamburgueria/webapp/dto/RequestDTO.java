package br.com.dextra.hamburgueria.webapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class used to represent the information of all existing requests done by a {@link ClientDTO}.
 *
 * @author rafaelcustodio
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestDTO {

    private Long id;

    @NotNull(message = "O valor do pedido é obrigatório.")
    private Double total;

    @NotNull(message = "O cliente é obrigatório.")
    private ClientDTO client;

    @NotEmpty(message = "Os ingredientes são obrigatórios.")
    private List<IngredientDTO> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
