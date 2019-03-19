package br.com.dextra.hamburgueria.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class responsible for setting up the application.
 *
 * @author rafaelcustodio
 */
@SpringBootApplication
@EntityScan(basePackages = {"br.com.dextra.hamburgueria.webapp.model"}, basePackageClasses = {Jsr310JpaConverters.class})
@EnableJpaRepositories(basePackages = "br.com.dextra.hamburgueria.webapp.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}