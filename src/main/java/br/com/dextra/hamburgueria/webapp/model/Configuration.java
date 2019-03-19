package br.com.dextra.hamburgueria.webapp.model;

import br.com.dextra.hamburgueria.webapp.enumerable.ConfigurationCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Class used to represent the information of all existing configuration variables stored on the database.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "CONFIGURATION")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "O código da configuração é obrigatório.")
    @Column(name = "CODE")
    private ConfigurationCode code;

    @NotEmpty(message = "O valor da configuração é obrigatório.")
    @Column(name = "VALUE")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConfigurationCode getCode() {
        return code;
    }

    public void setCode(ConfigurationCode code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
