package br.com.dextra.hamburgueria.webapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class used to represent the information of a client stored on the database.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "O nome do cliente é obrigatório.")
    @Column(name = "NAME")
    private String name;

    @NotNull(message = "O numero fiscal do cliente é obrigatório.")
    @Column(name = "FISCAL_NUMBER")
    private Long fiscalNumber;

    @OneToMany(mappedBy = "client")
    private List<Request> requests;

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

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
