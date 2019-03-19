package br.com.dextra.hamburgueria.webapp.controller;

import br.com.dextra.hamburgueria.webapp.dto.RequestDTO;
import br.com.dextra.hamburgueria.webapp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Class responsible for mapping all the endpoints that handle process related to a {@link br.com.dextra.hamburgueria.webapp.model.Request}.
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(value = "/requests", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RequestDTO> findAll() {
        return this.requestService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RequestDTO findOne(@PathVariable("id") final Long id) {
        return this.requestService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RequestDTO save(@RequestBody @Valid final RequestDTO client) {
        return this.requestService.save(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RequestDTO update(@PathVariable("id") final Long id, @RequestBody @Valid final RequestDTO client) {
        return this.requestService.save(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        this.requestService.delete(id);
    }
}