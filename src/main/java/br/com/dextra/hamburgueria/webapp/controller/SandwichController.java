package br.com.dextra.hamburgueria.webapp.controller;

import br.com.dextra.hamburgueria.webapp.dto.SandwichDTO;
import br.com.dextra.hamburgueria.webapp.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class responsible for mapping all the endpoints that handle process related to a {@link br.com.dextra.hamburgueria.webapp.model.Sandwich}.
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(value = "/sandwiches", produces = MediaType.APPLICATION_JSON_VALUE)
public class SandwichController {

    @Autowired
    private SandwichService sandwichService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SandwichDTO> findAll() {
        return this.sandwichService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SandwichDTO findOne(@PathVariable("id") final Long id) {
        return this.sandwichService.findOne(id);
    }
}