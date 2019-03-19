package br.com.dextra.hamburgueria.webapp.dto;

import br.com.dextra.hamburgueria.webapp.enumerable.PromotionAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Class used to represent the information of all existing promotions for a specific combination of {@link IngredientDTO}.
 *
 * @author rafaelcustodio
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionDTO {

    private Long id;

    @NotEmpty(message = "O nome da promoção é obrigatório.")
    private String name;

    @NotEmpty(message = "A sigla da promoção é obrigatóra.")
    private PromotionAlias alias;

    @NotNull(message = "O valor do desconto é obrigatório.")
    private Double discount;

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

    public PromotionAlias getAlias() {
        return alias;
    }

    public void setAlias(PromotionAlias alias) {
        this.alias = alias;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
