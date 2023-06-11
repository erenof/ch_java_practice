package com.coderhouse.clase10.service;

import com.coderhouse.clase10.model.Client;
import com.coderhouse.clase10.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client postClient(Client client) throws Exception {
        return clientRepository.save(client);
    }

    public Client getClient(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()){
            throw new Exception("Client with id: " + id + ", not found");
        } else {
            return client.get();
        }
    }

    public boolean clientExist (int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        return client.isPresent();
    }
}
