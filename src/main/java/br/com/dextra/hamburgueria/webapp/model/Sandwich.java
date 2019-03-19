package br.com.dextra.hamburgueria.webapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Class used to represent the information of all existing sandwiches for a specific combination of {@link Ingredient}.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "SANDWICH")
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "O nome do lanche é obrigatório.")
    @Column(name = "NAME")
    private String name;

    @NotEmpty(message = "Os ingredientes do lanche são obrigatórios.")
    @ManyToMany
    @JoinTable(
            name = "SANDWICH_INGREDIENT",
            joinColumns = @JoinColumn(name = "ID_SANDWICH"),
            inverseJoinColumns = @JoinColumn(name = "ID_INGREDIENT")
    )
    private List<Ingredient> ingredients;

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
