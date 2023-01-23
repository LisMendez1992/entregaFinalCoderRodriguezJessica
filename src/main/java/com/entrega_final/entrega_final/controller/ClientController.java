package com.entrega_final.entrega_final.controller;

import com.entrega_final.entrega_final.entidades.Client;
import com.entrega_final.entrega_final.servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Client> findClientById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createClient(@RequestBody @Valid Client client) {
        try {
            return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            clientService.deleteClient(id);
            return ResponseEntity.ok("Se elimino el cliente correctamente");
        } else {
            throw new RuntimeException();
        }

    }

}
