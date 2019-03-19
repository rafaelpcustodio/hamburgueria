package br.com.dextra.hamburgueria.webapp.controller;

import br.com.dextra.hamburgueria.webapp.dto.ClientDTO;
import br.com.dextra.hamburgueria.webapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Class responsible for mapping all the endpoints that handle process related to a {@link br.com.dextra.hamburgueria.webapp.model.Client}.
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> findAll() {
        return this.clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO findOne(@PathVariable("id") final Long id) {
        return this.clientService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO save(@RequestBody @Valid final ClientDTO client) {
        return this.clientService.save(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO update(@PathVariable("id") final Long id, @RequestBody @Valid final ClientDTO client) {
        return this.clientService.save(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        this.clientService.delete(id);
    }
}