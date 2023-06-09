package com.coderhouse.clase10.controller;

import com.coderhouse.clase10.middleware.ResponseHandler;
import com.coderhouse.clase10.model.Client;
import com.coderhouse.clase10.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // CRUD Client
    // Create
    @PostMapping
    public ResponseEntity<Object> postClient (@RequestBody Client client){
        try{
            System.out.println(client);
            Client clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Client stored successfully",
                    HttpStatus.OK,
                    clientSaved
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Get client details
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            Client clientFound = clientService.getClient(id);
            return ResponseHandler.generateResponse("Client retrieved", HttpStatus.OK, clientFound);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

}
