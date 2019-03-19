package br.com.dextra.hamburgueria.webapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class used to represent the information of all existing requests done by a {@link Request}.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "INVOICE")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull(message = "O valor do pedido é obrigatório.")
    @Column(name = "TOTAL")
    private Double total;

    @NotNull(message = "O cliente é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
    private Client client;

    @NotEmpty(message = "Os ingredientes são obrigatórios.")
    @ManyToMany
    @JoinTable(
            name = "INVOICE_INGREDIENT",
            joinColumns = @JoinColumn(name = "ID_INVOICE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "ID")
    )
    @Transient
    private List<Ingredient> ingredients;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
