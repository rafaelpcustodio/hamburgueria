package br.com.dextra.hamburgueria.common.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class responsible for setting up the unit tests context.
 *
 * @author rafaelcustodio
 */
@SpringBootApplication(scanBasePackages = {"br.com.dextra.hamburgueria.webapp"})
@EntityScan(basePackages = {"br.com.dextra.hamburgueria.webapp.model"}, basePackageClasses = {Jsr310JpaConverters.class})
@EnableJpaRepositories(basePackages = "br.com.dextra.hamburgueria.webapp.repository")
public class TestRootConfig {
}