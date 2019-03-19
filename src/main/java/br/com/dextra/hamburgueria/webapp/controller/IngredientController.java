package br.com.dextra.hamburgueria.webapp.controller;

import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import br.com.dextra.hamburgueria.webapp.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class responsible for mapping all the endpoints that handle process related to a {@link br.com.dextra.hamburgueria.webapp.model.Ingredient}.
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(value = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IngredientDTO> findAll() {
        return this.ingredientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IngredientDTO findOne(@PathVariable("id") final Long id) {
        return this.ingredientService.findOne(id);
    }
}