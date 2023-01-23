package com.entrega_final.entrega_final.servicio;

import com.entrega_final.entrega_final.entidades.Client;
import com.entrega_final.entrega_final.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        Optional<Client> cli = clientRepository.findById(id);
        try{
            return cli.get();
        }catch (NoSuchElementException e){
            throw new  RuntimeException("No existe un cliente con ID: " + id);
        }

        }

    public Client save(Client clientRequest) {
        Client client = Client.builder()
                .name(clientRequest.getName())
                .surname(clientRequest.getSurname())
                .email(clientRequest.getEmail())
                .build();
        return clientRepository.save(client);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

}
