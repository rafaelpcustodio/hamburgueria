package br.com.dextra.hamburgueria.webapp.model;

import br.com.dextra.hamburgueria.webapp.enumerable.PromotionAlias;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class used to represent the information of all existing promotions for a specific combination of {@link Ingredient}.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "PROMOTION")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "O nome da promoção é obrigatório.")
    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "A sigla da promoção é obrigatóra.")
    @Column(name = "ALIAS")
    private PromotionAlias alias;

    @NotNull(message = "O valor do desconto é obrigatório.")
    @Column(name = "DISCOUNT")
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
