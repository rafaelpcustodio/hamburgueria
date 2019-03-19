package br.com.dextra.hamburgueria.webapp.model;

import br.com.dextra.hamburgueria.webapp.enumerable.IngredientAlias;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class used to represent the information of all existing ingredients stored on the database.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "O nome do ingrediente é obrigatório.")
    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "A sigla do ingrediente é obrigatóra.")
    @Column(name = "ALIAS")
    private IngredientAlias alias;

    @NotNull(message = "O preço do ingrediente é obrigatório.")
    @Column(name = "PRICE")
    private Double price;

    @ManyToMany(mappedBy = "ingredients")
    private List<Sandwich> sandwiches;

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

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }
}
